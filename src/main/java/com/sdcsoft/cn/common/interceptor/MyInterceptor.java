package com.sdcsoft.cn.common.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 	 * 1.发送请求时如果有拦截器，首先进入拦截器preHandle方法，
 * 	 * 返回值为fasle表示当前请求被拦截，
 * 	 * 返回值为true表示当前请求通过拦截器，进入后台请求方法，处理业务逻辑
 *	认证拦截器 判断用户是否登录 解决session报空指针
 */
public class MyInterceptor implements HandlerInterceptor {
	Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取session
		HttpSession session = request.getSession();
		//session.setMaxInactiveInterval(20);
		//判断用户是否存在，不存在就跳转到登录界面
		if(session.getAttribute("user") == null){
			logger.info("------:跳转到login页面！");
			response.sendRedirect(request.getContextPath() + "/timeout");
			logger.info("----"+request.getContextPath() + "/login");
			return false;
		}
			session.setAttribute("user", session.getAttribute("user"));
			return true;

	}
	/**
	 * 视图跳转之前触发postHandle方法
	 * */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {


	}
	/**
	 * 视图跳转之后触发afterCompletion方法
	 * */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {


	}

}


