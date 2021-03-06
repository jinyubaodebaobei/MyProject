package com.sunny.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CheckBox extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country = request.getParameter("country");
		System.out.println(country);
		
		// 通过getParameterValues("likes")获得复选框选择的值
		String[] likes = request.getParameterValues("likes");
		
		for(int i = 0; likes != null && i < likes.length; ++i) {
			System.out.println(likes[i]);
		}
	}
}
