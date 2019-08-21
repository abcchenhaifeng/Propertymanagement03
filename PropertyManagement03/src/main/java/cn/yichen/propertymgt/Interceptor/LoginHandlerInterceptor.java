package cn.yichen.propertymgt.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

	@Autowired
	@Qualifier("u-key")
	private ThreadLocal<String> threadlocal_ukey;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println(threadlocal_ukey);
		
		response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8848");
		response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");//当判定为预检请求后，设定允许请求的方法
		response.setHeader("Access-Control-Allow-Headers", //当判定为预检请求后，设定允许请求的头部类型
				"Timestamp,Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token, Access-Control-Allow-Headers, u-key");
		response.setHeader("Access-Control-Allow-Credentials", "true"); 
		response.setHeader("Access-Control-Max-Age", "3600");
		
		if ("OPTIONS".equals(request.getMethod())){
			return true;
		}
		
		String ukey = threadlocal_ukey.get();
		String header_ukey = request.getHeader("u-key");
		
		System.out.println(ukey);
		System.out.println(header_ukey);
		
		if (ukey != null && header_ukey != null && ukey.equals(header_ukey)) {
			return true;
		}
		
		return false;
	}
}
