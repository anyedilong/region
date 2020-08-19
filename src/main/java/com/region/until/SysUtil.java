package com.region.until;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.region.config.filter.StatelessParams;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.domain.ProcessStatus;
import com.region.moudles.common.domain.ResponseStatus;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;
import com.region.until.sha1.SHA1Encrypt;


/**
 * Created by Administrator on 2016/8/6.
 */
public class SysUtil {

	/**
	 * 获取缓存用户信息
	 * 
	 * @return
	 */
	public static UserCache sysUser(HttpServletRequest request, HttpServletResponse response) {

		// 客户端请求的授权码
		String securityToken = StatelessParams.getSecurityToken(request);
		// 将用户信息放入缓存中， key为 以securityToken加密的username
		String key = SHA1Encrypt.encryptToken(securityToken);
		// 验证缓存中无数据，需要重新获取缓存信息
		UserCache userCache = CacheUtils.get(CacheEmun.USER_CACHE, key, UserCache.class);
		if (null == userCache) {
			try {
				onAuthFail(response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userCache;
	}

	/**
	 * 
	 * @Description  清除该用户缓存
	 * @param request
	 * @param response
	 * @author sen
	 * @Date 2016年12月20日 下午3:54:24
	 */
	public static void removeThis(HttpServletRequest request, HttpServletResponse response) {
		
		// 客户端请求的授权码
		String securityToken = StatelessParams.getSecurityToken(request);
		// 将用户信息放入缓存中， key为 以securityToken加密的username
		String key = SHA1Encrypt.encryptToken(securityToken);

		CacheUtils.delete(CacheEmun.USER_CACHE, key);
	}
	
	/**
	 * 
	 * <li>描述:身份认证错误默认返回401状态码</li>
	 * <li>方法名称:onAuthFail</li>
	 * <li>参数:@param response
	 * <li>参数:@throws Exception</li>
	 * <li>返回类型:void</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	private static void onAuthFail(ServletResponse response) throws Exception {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		response.setContentType("application/json;charset=UTF-8");
		JsonResult ret = new JsonResult("身份认证错误", ProcessStatus.AUTH_ERROR);
		ret.setResponseStatus(ResponseStatus.HTTP_UNAUTHORIZED);
		//httpResponse.getWriter().write(ret.toJsonString());
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}
}
