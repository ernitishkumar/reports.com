package com.mongo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongo.beans.ErrorBean;
import com.mongo.dao.UserDAO;
import com.mongo.utility.GlobalResources;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO=GlobalResources.getUserDAO();
	private Gson gson=GlobalResources.getGson();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login Called");
		String username=(String)request.getParameter("username");
		String password=(String)request.getParameter("password");
        System.out.println("Username and password from request : "+username+" "+password);
		boolean invalid=false;
		if(username!=null && password!=null){
			Document user=userDAO.getByUsername(username);
			if(user!=null && password.trim().equals(user.getString("password").trim())){
				System.out.println("Not matched");
			}else{
				invalid=true;
			}
		}else{
			invalid=true;
		} 
		
		if(invalid){
            System.out.print("Sending error");
			ErrorBean errorBean=new ErrorBean("Invalid username/password.");
			response.setContentType("text/json");
			response.getWriter().write(gson.toJson(errorBean));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
