package com.dao;
import com.beans.*;
import com.utility.*;
import java.util.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
public class MeterConnectionDAO{
	public ArrayList<MeterConnection> get(){
		ArrayList<MeterConnection> meterConnections=new ArrayList<MeterConnection>();
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		try{
			connection = GeneralResources.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select DISTINCT(LOC_CODE_1) from DL");

			ArrayList<String> locations=new ArrayList<String>();

			while(rs.next()){
				locations.add(rs.getString(1));
			}

			System.out.println("Count of locations from MeterConnectionDAO : "+locations.size());

			int i=0;
			String lcode;
			String id,divName,locName,locCode,consName,arrs,addr,groupNo,readerNo,consNo,consLoad,loadUnit,netBill,tariff;
			
			while(i<locations.size()){
				lcode=locations.get(i);
				rs=statement.executeQuery("select * from DL where LOC_CODE_1="+lcode+" order by ARRS desc limit 20");

				while(rs.next()){
					id=rs.getString(1).trim();
					divName=rs.getString(2).trim();
					locCode=rs.getString(3).trim();
					locName=rs.getString(4).trim();
					consName=rs.getString(5).trim();
					addr=rs.getString(6).trim();
					groupNo=rs.getString(8).trim();
					readerNo=rs.getString(9).trim();
					consNo=rs.getString(10).trim();
					consLoad=rs.getString(11).trim();
					loadUnit=rs.getString(12).trim();
					arrs=rs.getString(13).trim();
					netBill=rs.getString(14).trim();
					tariff=rs.getString(15);
				//	System.out.println("Single row : "+id+" "+divName+" "+locCode+" "+locName+" "+consName+" "+addr+" "+groupNo+" "+readerNo+" "+consNo+" "+consLoad+" "+loadUnit+" "+arrs+" "+netBill+" "+tariff);
					MeterConnection mc=new MeterConnection(id,divName,locCode,locName,consName,addr,"",groupNo,readerNo,consNo,consLoad,loadUnit,arrs,netBill,tariff);
					meterConnections.add(mc);

				}

				i++;
			}

		}catch(Exception exp){
			System.out.println("Exception in MeterConnectionDAO : get() "+exp);
		}finally{
/*			try{
				if(rs!=null && !rs.isClosed()) rs.close();
				if(statement!=null && !statement.isClosed()) statement.close();
			}catch(SQLException sqlExp){

			}*/
			
		}

		return meterConnections;
	}

	public ArrayList<MeterConnection> get(String count){
		ArrayList<MeterConnection> meterConnections=new ArrayList<MeterConnection>();
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		try{
			connection = GeneralResources.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select DISTINCT(LOC_CODE_1) from DL");

			ArrayList<String> locations=new ArrayList<String>();

			while(rs.next()){
				locations.add(rs.getString(1));
			}

			System.out.println("Count of locations from MeterConnectionDAO : "+locations.size());

			int i=0;
			String lcode;
			String id,divName,locName,locCode,consName,arrs,addr,groupNo,readerNo,consNo,consLoad,loadUnit,netBill,tariff;
			
			while(i<locations.size()){
				lcode=locations.get(i);
				if(count!=null && count.trim().toLowerCase().equals("all")){
					rs=statement.executeQuery("select * from DL where LOC_CODE_1="+lcode+" order by ARRS desc");
				}else{
					rs=statement.executeQuery("select * from DL where LOC_CODE_1="+lcode+" order by ARRS desc limit "+count);
				}
				

				while(rs.next()){
					id=rs.getString(1).trim();
					divName=rs.getString(2).trim();
					locCode=rs.getString(3).trim();
					locName=rs.getString(4).trim();
					consName=rs.getString(5).trim();
					addr=rs.getString(6).trim();
					groupNo=rs.getString(8).trim();
					readerNo=rs.getString(9).trim();
					consNo=rs.getString(10).trim();
					consLoad=rs.getString(11).trim();
					loadUnit=rs.getString(12).trim();
					arrs=rs.getString(13).trim();
					netBill=rs.getString(14).trim();
					tariff=rs.getString(15);
				//	System.out.println("Single row : "+id+" "+divName+" "+locCode+" "+locName+" "+consName+" "+addr+" "+groupNo+" "+readerNo+" "+consNo+" "+consLoad+" "+loadUnit+" "+arrs+" "+netBill+" "+tariff);
					MeterConnection mc=new MeterConnection(id,divName,locCode,locName,consName,addr,"",groupNo,readerNo,consNo,consLoad,loadUnit,arrs,netBill,tariff);
					meterConnections.add(mc);

				}

				i++;
			}

		}catch(Exception exp){
			System.out.println("Exception in MeterConnectionDAO : get() "+exp);
		}finally{
/*			try{
				if(rs!=null && !rs.isClosed()) rs.close();
				if(statement!=null && !statement.isClosed()) statement.close();
			}catch(SQLException sqlExp){

			}*/
			
		}

		return meterConnections;
	}
	public ArrayList<String> getAllLocations(){
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		ArrayList<String> locations=new ArrayList<String>();
		try{
			connection = GeneralResources.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery("select DISTINCT(LOC_CODE_1) from DL");

			while(rs.next()){
				locations.add(rs.getString(1));
			}

			System.out.println("Count of locations from MeterConnectionDAO : "+locations.size());

		}catch(Exception exp){
			System.out.println("Exception in MeterConnectionDAO : getAllLocations() "+exp);
		}finally{
/*			try{
				if(rs!=null && !rs.isClosed()) rs.close();
				if(statement!=null && !statement.isClosed()) statement.close();
			}catch(SQLException sqlExp){

			}
*/			
		}

		return locations;
	}

	public ArrayList<MeterConnection> getByLocationCode(String location,String count){
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		ArrayList<MeterConnection> meterConnections=new ArrayList<MeterConnection>();
		try{

			connection = GeneralResources.getConnection();
			statement = connection.createStatement();
			if(count.trim().equals("ALL")){
				rs = rs=statement.executeQuery("select * from DL where LOC_CODE_1="+location+" order by ARRS desc");
			}else{
				rs = rs=statement.executeQuery("select * from DL where LOC_CODE_1="+location+" order by ARRS desc limit "+count.trim());				
			}
			

			String lcode;
			String id,divName,locName,locCode,consName,arrs,addr,groupNo,readerNo,consNo,consLoad,loadUnit,netBill,tariff;
			
			while(rs.next()){
				id=rs.getString(1).trim();
				divName=rs.getString(2).trim();
				locCode=rs.getString(3).trim();
				locName=rs.getString(4).trim();
				consName=rs.getString(5).trim();
				addr=rs.getString(6).trim();
				groupNo=rs.getString(8).trim();
				readerNo=rs.getString(9).trim();
				consNo=rs.getString(10).trim();
				consLoad=rs.getString(11).trim();
				loadUnit=rs.getString(12).trim();
				arrs=rs.getString(13).trim();
				netBill=rs.getString(14).trim();
				tariff=rs.getString(15);
				//	System.out.println("Single row : "+id+" "+divName+" "+locCode+" "+locName+" "+consName+" "+addr+" "+groupNo+" "+readerNo+" "+consNo+" "+consLoad+" "+loadUnit+" "+arrs+" "+netBill+" "+tariff);
				MeterConnection mc=new MeterConnection(id,divName,locCode,locName,consName,addr,"",groupNo,readerNo,consNo,consLoad,loadUnit,arrs,netBill,tariff);
				meterConnections.add(mc);
			}

		}catch(Exception exp){
			System.out.println("Exception in MeterConnectionDAO : getByLocationcode() "+exp);
		}
		finally{
			/*try{
				if(rs!=null && !rs.isClosed()) rs.close();
				if(statement!=null && !statement.isClosed()) statement.close();
			}catch(SQLException sqlExp){

			}*/
			
		}
		return meterConnections;
	}

	public ArrayList<MeterConnection> getByLocationName(String location,String count){
		Connection connection=null;
		Statement statement=null;
		ResultSet rs=null;
		ArrayList<MeterConnection> meterConnections=new ArrayList<MeterConnection>();
		try{

			connection = GeneralResources.getConnection();
			statement = connection.createStatement();
			if(count.trim().equals("ALL")){
				rs = rs=statement.executeQuery("select * from DL where LOC_NAME="+location+" order by ARRS desc");
			}else{
				rs = rs=statement.executeQuery("select * from DL where LOC_NAME="+location+" order by ARRS desc limit "+count.trim());				
			}
			

			String lcode;
			String id,divName,locName,locCode,consName,arrs,addr,groupNo,readerNo,consNo,consLoad,loadUnit,netBill,tariff;
			
			while(rs.next()){
				id=rs.getString(1).trim();
				divName=rs.getString(2).trim();
				locCode=rs.getString(3).trim();
				locName=rs.getString(4).trim();
				consName=rs.getString(5).trim();
				addr=rs.getString(6).trim();
				groupNo=rs.getString(8).trim();
				readerNo=rs.getString(9).trim();
				consNo=rs.getString(10).trim();
				consLoad=rs.getString(11).trim();
				loadUnit=rs.getString(12).trim();
				arrs=rs.getString(13).trim();
				netBill=rs.getString(14).trim();
				tariff=rs.getString(15);
				//	System.out.println("Single row : "+id+" "+divName+" "+locCode+" "+locName+" "+consName+" "+addr+" "+groupNo+" "+readerNo+" "+consNo+" "+consLoad+" "+loadUnit+" "+arrs+" "+netBill+" "+tariff);
				MeterConnection mc=new MeterConnection(id,divName,locCode,locName,consName,addr,"",groupNo,readerNo,consNo,consLoad,loadUnit,arrs,netBill,tariff);
				meterConnections.add(mc);
			}

		}catch(Exception exp){
			System.out.println("Exception in MeterConnectionDAO : getByLocationName() "+exp);
		}
		finally{
			/*try{
				if(rs!=null && !rs.isClosed()) rs.close();
				if(statement!=null && !statement.isClosed()) statement.close();
			}catch(SQLException sqlExp){

			}
			*/
		}
		return meterConnections;
	}

}