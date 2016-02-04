package com.reports;
import com.dao.*;
import com.utility.*;
import com.beans.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;
public class Reporter extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		String location=request.getParameter("location");
		String count=request.getParameter("count");
		MeterConnectionDAO meterConnectionDAO=new MeterConnectionDAO();
		ArrayList<MeterConnection> connections=null;
		if(location==null && count==null){
			System.out.println("Both parameters are null. Backdoor entry. Redirecting to home page");
			response.sendRedirect("home.jsp");
			return;
		}else if(location.trim().toLowerCase().equals("all")){
			System.out.println("Request for all locations");
			connections=meterConnectionDAO.get(count);
			System.out.println("get fetched rows : "+connections.size());
		}else{
			System.out.println("location and count from request is : "+location+" "+count);
			connections=meterConnectionDAO.getByLocationCode(location,count);
			System.out.println("getByLocationCode fetched rows : "+connections.size());
		}
		request.setAttribute("connections", connections);
		RequestDispatcher rd = request.getRequestDispatcher("displaydata.jsp");
		rd.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}