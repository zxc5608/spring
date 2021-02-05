package kr.or.ddit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 정상 접속인지 확인하는 로직: session에 S_USER속성이 있는지 검사 
		if(request.getSession().getAttribute("S_USER")==null) {
			response.sendRedirect("/login/view");
			return false;
		}
		
		return true;
	}

}
