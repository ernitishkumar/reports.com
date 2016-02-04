package com.tags;
import javax.servlet.jsp.JspException;  
import javax.servlet.jsp.JspWriter;  
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Calendar;
import com.beans.*;
import com.dao.*; 
import java.util.ArrayList; 
public class RowPrinter extends TagSupport{

private MeterConnectionDAO meterConnectionDAO=new MeterConnectionDAO();
	public int doStartTag() throws JspException {
	  JspWriter out=pageContext.getOut();//returns the instance of JspWriter 
	  ArrayList<MeterConnection> connections=new ArrayList<MeterConnection>(); 
	  connections=meterConnectionDAO.get();
	  System.out.println("Count of rows from RowPrinter : "+connections.size());
	  try{
	  	int i=1;
	  	for(MeterConnection mc:connections){
	  	/*	System.out.println("Id : "+mc.getId());
	  		System.out.println("Divison name :" +mc.getDivisionName());
	  	*/	
	  		out.print("<tr>");
	  		out.print("<td>"+i+++"</td>");
	  		out.print("<td>"+mc.getId()+"</td>");

	  		out.print("<td>"+mc.getDivisionName()+"</td>");

	  		out.print("<td>"+mc.getLocationCode()+"</td>");

	  		out.print("<td>"+mc.getLocationName()+"</td>");

	  		out.print("<td>"+mc.getConnectionName()+"</td>");

	  		out.print("<td>"+mc.getFirstAddress()+"</td>");

	  		out.print("<td>"+mc.getArrears()+"</td>");

	  		out.print("</tr>");
	  	}
	  }catch(Exception jspExp){
	  	System.out.println("Exception in RowPrinter class : doStartTag() : "+jspExp);
	  }
         return EVAL_BODY_INCLUDE;//will not evaluate the body content of the tag  
     }  
 }