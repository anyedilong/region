package com.region.moudles.common.controller;

import org.apache.shiro.codec.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.region.config.filter.StatelessParams;
import com.region.config.spring.InstanceFactory;
import com.region.moudles.common.domain.JsonResult;
import com.region.moudles.common.utils.cache.UserCache;
import com.region.moudles.system.dao.repository.SysBlackBillRepository;
import com.region.moudles.system.domain.SysBlackBill;
import com.region.moudles.system.domain.SysUser;
import com.region.moudles.system.service.InitService;
import com.region.moudles.system.service.SysUserService;
import com.region.until.StringUntil;
import com.region.until.UUIDUtil;
import com.region.until.cache.CacheEmun;
import com.region.until.cache.CacheUtils;
import com.region.until.encode.Md5Encrypt;
import com.region.until.rsa.RSAUtil;
import com.region.until.sha1.SHA1Encrypt;

/**
 * <br>
 * <b>功能：</b>CustomerController<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2016，blt<br>
 */
@RestController
@RequestMapping("login")
public class LoginController extends BaseController {

	@Autowired
	private SysUserService userService;
	@Autowired
	private SysBlackBillRepository bbRepository;

	/**
	 * @Description 返回一个安全码
	 * @return
	 * @author sen
	 * @Date 2017年2月15日 下午4:43:55
	 */
	@RequestMapping("getAuthToken")
	public JsonResult getAuthToken() {
		try {
			String uuid = UUIDUtil.getUUID();
			String baseSecurity = Base64.encodeToString(uuid.getBytes());
			String authToken = Base64.encodeToString((baseSecurity).getBytes());
			CacheUtils.put(CacheEmun.SYS_CACHE, baseSecurity, uuid);
			JsonResult result = new JsonResult();
			result.setAuthorToke(authToken);
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * <li>描述:用户登录</li>
	 * <li>方法名称:check</li>
	 * <li>参数:@param response
	 * <li>参数:@param request
	 * <li>参数:@return</li>
	 * <li>返回类型:String</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	@RequestMapping("index")
	public JsonResult index() {
		try {
		    String param=getParam(request);
		    JSONObject paramObj = JSONObject.parseObject(param);
		    String userName = paramObj.getString("username");
		    if(StringUntil.isNull(userName)) {
		    	return jsonResult(null, 10001, "请输入用户名！");
		    }
		    String password = paramObj.getString("password");
		    if(StringUntil.isNull(userName)) {
		    	return jsonResult(null, 10001, "请输入密码！");
		    }
		    //获取客户端的ip
			String ip = paramObj.getString("ip");
			SysBlackBill info = bbRepository.queryInfoByIp(ip);
			if(info != null && "1".equals(info.getStatus())) {
				return jsonResult(null, 11001, "电脑已被锁定，请联系上级管理员解冻");
			}
			// 根据登录名获取账号信息
			SysUser user = userService.getUserByUserName(userName);

			if (null != user) {
				String pwd = user.getPassword();
				password = Md5Encrypt.getMD5Code(RSAUtil.decrypt(password));
				if (password.equals(pwd)) {
					//验证用户是否可以正常使用
					if("2".equals(user.getStatus())){
						return jsonResult(null, 30001, "用户已冻结，请联系上级管理员解冻");
					}
					// 客户端请求的授权码
					//String authorToken = StatelessParams.getSecurityToken(request);
					//if (StringUntil.isNull(authorToken)) {
						// 身份认证错误
						//lockUser("loginError");
						//return jsonResult(null, ProcessStatus.AUTH_ERROR);
					//}
					//获取存储securitytoken的key
					//String tokenKey = Base64.encodeToString(authorToken.getBytes());
					//String cacheToken = CacheUtils.get(CacheEmun.SYS_CACHE, tokenKey, String.class);
					//if(!authorToken.equals(cacheToken)) {
						// 身份认证错误
						//lockUser("loginError");
						//return jsonResult(null, ProcessStatus.AUTH_ERROR);
					//}
					UserCache userCache = InstanceFactory.getbean(InitService.class).getUserInfo(userName);
					
					bbRepository.deleteByIp(ip);
					JsonResult jsonResult = new JsonResult();
					//删除缓存中的旧的key值保存的数据
					//CacheUtils.delete(CacheEmun.SYS_CACHE, tokenKey);
					//生成新的key值
					String uuid = UUIDUtil.getUUID();
					String baseSecurity = Base64.encodeToString(uuid.getBytes());
					String newAuthToken = Base64.encodeToString((baseSecurity).getBytes());
					// 将用户信息放入缓存新的key值中
					String newKey = SHA1Encrypt.encryptToken(uuid);
					CacheUtils.put(CacheEmun.USER_CACHE, newKey, userCache);
					CacheUtils.put(CacheEmun.SYS_CACHE, baseSecurity, uuid);
					jsonResult.setAuthorToke(newAuthToken);
					return jsonResult;
				} else {
					// 密码错误
					lockUser("loginError", ip);
					return jsonResult(null, 20001, "账户名与密码不匹配，请重新输入");
				}
			} else {
				// 用户名不存在
				lockUser("loginError", ip);
				return jsonResult(null, 20002, "账户名不存在，请重新输入");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description 用户退出
	 * @return
	 * @author tz
	 */
	@RequestMapping("exit")
	public JsonResult exit() {
		try {
			// 客户端请求的授权码
			String authorToken = StatelessParams.getSecurityToken(request);
			String tokenKey = Base64.encodeToString(authorToken.getBytes());
			String oldKey = SHA1Encrypt.encryptToken(authorToken);
			//删除缓存中的旧的key值保存的数据
			CacheUtils.delete(CacheEmun.USER_CACHE, oldKey);
			CacheUtils.delete(CacheEmun.SYS_CACHE, tokenKey);
			return jsonResult();
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null,10001,"系统错误"); 
		}
	}
	
	/**
	 * @Description 锁定使用者的ip
	 * @return
	 * @author tz
	 */
	@RequestMapping("giveSurprise")
	public void giveSurprise() {
		try {
			String param=getParam(request);
		    JSONObject paramObj = JSONObject.parseObject(param);
		    //获取客户端的ip
			String ip = paramObj.getString("ip");
			lockUser("surprise", ip);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void lockUser(String flag, String ip)throws Exception {
		//String ip = InetAddress.getLocalHost().getHostAddress();
		SysBlackBill info = bbRepository.queryInfoByIp(ip);
		if(info == null) {
			SysBlackBill bill = new SysBlackBill();
			bill.setId(UUIDUtil.getUUID());
			bill.setUserIp(ip);
			if("surprise".equals(flag) ) {
				bill.setStatus("1");
			}else {
				bill.setTimes(1);
				bill.setStatus("0");
			}
			bbRepository.save(bill);
		}else if("0".equals(info.getStatus())) {
			Integer times = info.getTimes() + 1;
			if(times < 9) {
				bbRepository.updateInfo(ip, times, "0");
			}else {
				bbRepository.updateInfo(ip, times, "1");
			}
		}
	}
}
