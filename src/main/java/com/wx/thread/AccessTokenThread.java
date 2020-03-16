package com.wx.thread;

import javax.servlet.ServletContext;

import com.wx.pojo.AccessToken;
import com.wx.utils.CommonUtil;
import com.wx.utils.ServletContextUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 用appid和appsecret获取access_token，每两小时重新获取一次
 */
public class AccessTokenThread implements Runnable {
	private static final Log log = LogFactory.getLog(AccessTokenThread.class);
	public static String appid = "";
	public static String appsecret = "";
	public static AccessToken accessToken = null;
	@Override
	public void run() {
		while (true) {
			try {
				accessToken = CommonUtil.getAccessToken(appid, appsecret);
				if (null != accessToken) {
					log.info("获取accessToken成功");
					log.info("accessToken初始化成功:" + accessToken.getAccessToken());
					// 全局缓存access_token
					ServletContext servletContext = ServletContextUtil.getServletContext();
					servletContext.setAttribute("access_token", accessToken.getAccessToken());
					
					// 有效期（秒）减去200秒，乘以1000(毫秒)——也就是在有效期的200秒前去请求新的accessToken
					Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
				} else {
					// 等待一分钟，再次请求
					System.out.println("AccessTokenThread等待一分钟，再次请求");
					Thread.sleep(10 * 1000);
				}
			} catch (Exception e) {
				try {
					// 等待一分钟，再次请求
					Thread.sleep(60 * 1000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}
}
