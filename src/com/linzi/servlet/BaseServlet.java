package com.linzi.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.iap.Response;
/**
 * 自定义一个BaseServlet 类，继承了HttpServlet 我们可以在这里写自己的方法，来简化我们的serlvet
 * @author PCPC
 *
 */

public class BaseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.第一步，获得方法名。
		 */
		String methodName=request.getParameter("method");
		/*
		 * 2. 第二步，由方法名我们来得到我们的方法类
		 */
		Method method=null;
		try {
			method=this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			/*
			 * 3.第三步:由方法类，我们来调用方法 
			 */
		String result=	(String) method.invoke(this, request,response);
		/*
		 * 4.第四步：利用返回的值 我来确定与转发与重定向
		 * 
		 */
		if(result!=null&&!result.trim().isEmpty()){
		String [] str=result.split(":");
		
		if(str[0].equals("f")){
			System.out.println("转发到主页");
			request.getRequestDispatcher(str[1]).forward(request, response);
		}else if(str[0].equals("r")){
			System.out.println("重定向到主页");
			response.sendRedirect(request.getContextPath()+str[1]);
		}
		}
		} catch (Exception e) {
			throw new RuntimeException("没有你请求的"+methodName+"方法！",e);
		}
		
		
		
		
	}
	
	
}
