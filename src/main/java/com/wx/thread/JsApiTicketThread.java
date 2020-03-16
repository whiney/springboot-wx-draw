package com.wx.thread;

import javax.servlet.ServletContext;

import com.wx.pojo.JsApiTicket;
import com.wx.utils.CommonUtil;
import com.wx.utils.ServletContextUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 用access_token获取jsp_ticket，每两小时重新获取一次
 */
public class JsApiTicketThread implements Runnable {
	private static final Log log = LogFactory.getLog(JsApiTicketThread.class);
	@Override
	public void run() {
		while (true) {
			try {
				ServletContext servletContext = ServletContextUtil.getServletContext();
				String access_token = (String) servletContext.getAttribute("access_token");
				
				JsApiTicket jsApiTicket = null;
				
				if(null != access_token && !"".equals(access_token)){
					// 获取jsapi_ticket
					jsApiTicket = CommonUtil.getJsApiTicket(access_token);
					
					if (null != jsApiTicket) {
						log.info("jsapi_ticket获取成功:" + jsApiTicket.getTicket());
						// 全局缓存jsapi_ticket
						servletContext.setAttribute("jsapi_ticket", jsApiTicket.getTicket());

						Thread.sleep((jsApiTicket.getExpiresIn() - 200) * 1000);
					}
				}else {
					// log.info("JsApiTicketThread等待一分钟，再次请求");
					Thread.sleep(10 * 1000);
				}
			} catch (Exception e) {
				try {
					Thread.sleep(60 * 1000);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				e.printStackTrace();
			}
		}
	}

}
