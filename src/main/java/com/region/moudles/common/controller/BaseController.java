package com.region.moudles.common.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.codec.Base64;

import com.region.config.filter.StatelessParams;
import com.region.moudles.common.domain.JsonHisResult;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.ProcessStatus;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;
import com.region.until.sha1.SHA1Encrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

	@Resource
	protected HttpServletRequest request;

	@Resource
	protected HttpServletResponse response;
	protected Logger logger = LoggerFactory.getLogger(getClass());
	/**
	 * 客户端返回字符串
	 * 
	 * @param response
	 * @param string
	 * @return
	 */
	protected String renderString(HttpServletResponse response, String string, String type) {
		try {
			response.reset();
			response.setContentType(type);
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(string);
			return null;
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 
	 * <li>描述:结果集 默认状态为0</li>
	 * <li>方法名称:jsonResult</li>
	 * <li>参数:@param data
	 * <li>参数:@return</li>
	 * <li>返回类型:JsonResult</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	public JsonResult jsonResult(Object data) {
		JsonResult result = new JsonResult(data);
		// updateSecurityTokeResult(result);
		return result;
	}

	public JsonResult jsonResult() {
		JsonResult result = new JsonResult(null);
		// updateSecurityTokeResult(result);
		return result;
	}

	public JsonHisResult JsonHisResult(ArrayList<String> faillist, int retCode, String retMsg) {
		JsonHisResult result = new JsonHisResult(retCode, retMsg, faillist);
		return result;
	}

	/**
	 * 
	 * <li>描述:结果集加状态</li>
	 * <li>方法名称:jsonResult</li>
	 * <li>参数:@param data
	 * <li>参数:@param status
	 * <li>参数:@return</li>
	 * <li>返回类型:JsonResult</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	public JsonResult jsonResult(Object data, ProcessStatus status) {
		JsonResult result = new JsonResult(data, status);
		// updateSecurityTokeResult(result);
		return result;
	}

	/**
	 * 
	 * <li>描述:</li>
	 * <li>方法名称:jsonResult</li>
	 * <li>参数:@param data 结果
	 * <li>参数:@param propertyKey 配置文件中的key
	 * <li>参数:@return</li>
	 * <li>返回类型:JsonResult</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	public JsonResult jsonResult(Object data, String propertyKey) {
		ProcessStatus status = new ProcessStatus();
		JsonResult result = new JsonResult(data, status);
		// updateSecurityTokeResult(result);
		return result;
	}

	/**
	 * 
	 * <li>描述:</li>
	 * <li>方法名称:jsonResult</li>
	 * <li>参数:@param data
	 * <li>参数:@param retCode 状态码
	 * <li>参数:@param retMsg 描述
	 * <li>参数:@return</li>
	 * <li>返回类型:JsonResult</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	public JsonResult jsonResult(Object data, int retCode, String retMsg) {
		ProcessStatus status = new ProcessStatus(retCode, retMsg);
		JsonResult result = new JsonResult(data, status);
		return result;
	}

	private void updateSecurityTokeResult(JsonResult jsonResult) {
		if (jsonResult.getRetCode() == 0) {
			// 客户端请求的授权码
			String authorToken = StatelessParams.getSecurityToken(request);
			String tokenKey = Base64.encodeToString(authorToken.getBytes());
			String oldKey = SHA1Encrypt.encryptToken(authorToken);
			// 得到缓存中的用户信息
			UserCache userCache = CacheUtils.get(CacheEmun.USER_CACHE, oldKey, UserCache.class);
			// 删除缓存中的旧的key值保存的数据
			CacheUtils.delete(CacheEmun.USER_CACHE, oldKey);
			CacheUtils.delete(CacheEmun.SYS_CACHE, tokenKey);
			// 生成新的key值
			String uuid = UUIDUtil.getUUID();
			String baseSecurity = Base64.encodeToString(uuid.getBytes());
			String newAuthToken = Base64.encodeToString((baseSecurity).getBytes());
			// 将用户信息放入缓存新的key值中
			String newKey = SHA1Encrypt.encryptToken(uuid);
			CacheUtils.put(CacheEmun.USER_CACHE, newKey, userCache);
			CacheUtils.put(CacheEmun.SYS_CACHE, baseSecurity, uuid);
			System.out.println(">>>>>>>>>>>>>>>>>>>>>>" + newAuthToken);
			jsonResult.setAuthorToke(newAuthToken);
		}
	}

	public String getParam(HttpServletRequest request) {
		String paramStr = "";
		try {
			BufferedReader reader = null;
			request.setCharacterEncoding("UTF-8");
			reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
			String line = null;
			StringBuilder buffer = new StringBuilder();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			paramStr = new String(buffer);
			if (StringUntil.isNull(paramStr)) {
				paramStr = "{}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return paramStr;
	}
}
