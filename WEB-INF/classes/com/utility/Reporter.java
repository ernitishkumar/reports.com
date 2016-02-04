package com.utility;
import java.sql.*;
import java.io.*;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Reporter{

	public static void main(String gg[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mpeb" , 
				"root", 
				"kumar"
				);

			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery("select DISTINCT(LOC_CODE_1) from DL limit 2");

			XSSFWorkbook workbook = new XSSFWorkbook(); 
			XSSFSheet spreadsheet = workbook.createSheet("Top 50 Data");
			XSSFRow row=spreadsheet.createRow(0);
			XSSFCell cell;
			cell=row.createCell(0);
			cell.setCellValue("DIV_NAME");
			cell=row.createCell(1);
			cell.setCellValue("LOC_CODE_1");
			cell=row.createCell(2);
			cell.setCellValue("LOC_NAME");
			cell=row.createCell(3);
			cell.setCellValue("CONS_NAME_1");
			cell=row.createCell(4);
			cell.setCellValue("ARRS");

			ArrayList<String> locations=new ArrayList<String>();

			while(rs.next()){
				locations.add(rs.getString(1));
			}

			System.out.println("Count of locations : "+locations.size());

			int i=0;
			String lcode;
			String divName,locName,locCode,consName,arrs;
			int rowNum=1;
			while(i<locations.size()){
				lcode=locations.get(i);
				rs=statement.executeQuery("select DIV_NAME,LOC_CODE_1,LOC_NAME,CONS_NAME_1,ARRS from DL where LOC_CODE_1="+lcode+" order by ARRS desc limit 10");

				while(rs.next()){
					divName=rs.getString(1);
					locCode=rs.getString(2);
					locName=rs.getString(3);
					consName=rs.getString(4);
					arrs=rs.getString(5);

					System.out.println("Single row : "+divName+" "+locCode+" "+locName+" "+consName+" "+arrs);

					row=spreadsheet.createRow(rowNum++);
					cell=row.createCell(0);
					cell.setCellValue(divName);

					cell=row.createCell(1);
					cell.setCellValue(locCode);

					cell=row.createCell(2);
					cell.setCellValue(locName);

					cell=row.createCell(3);
					cell.setCellValue(consName);

					cell=row.createCell(4);
					cell.setCellValue(arrs);
				}

				i++;
			}

			FileOutputStream out = new FileOutputStream(new File("Reports.xlsx"));
			workbook.write(out);
			out.close();
			System.out.println("Reports.xlsx written successfully");
		}catch(Exception exp){
			System.out.println("Exception occured "+exp);
		}
	}
}
