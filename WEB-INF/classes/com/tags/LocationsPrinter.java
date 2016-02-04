package com.tags;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspException;  
import javax.servlet.jsp.JspWriter;  
import javax.servlet.jsp.tagext.TagSupport;
import java.util.Calendar;
import com.beans.*;
import com.dao.*; 
import java.util.ArrayList; 
public class LocationsPrinter extends TagSupport{

private MeterConnectionDAO meterConnectionDAO=new MeterConnectionDAO();
	public int doStartTag() throws JspException {
	  JspWriter out=pageContext.getOut();//returns the instance of JspWriter 
	  ArrayList<String> locations=new ArrayList<String>(); 
	  locations=meterConnectionDAO.getAllLocations();
	  System.out.println("Count of rows from LocationsPrinter : "+locations.size());
	  pageContext.setAttribute("locations", locations,PageContext.SESSION_SCOPE);
      return EVAL_BODY_INCLUDE;//will not evaluate the body content of the tag  
     }  
 }