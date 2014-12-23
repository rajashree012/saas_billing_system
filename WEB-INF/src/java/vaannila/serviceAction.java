package vaannila;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import java.io.*;
import java.lang.String;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;
import java.lang.*;



public class serviceAction extends ActionSupport {
	
	private String userId;
	
		
		
	private String[] service=new String[5];
	
	private ArrayList<String> serviceList;
	
	
	public String populate() {

				
		serviceList = new ArrayList<String>();
		serviceList.add("splan1");
		serviceList.add("splan2");
		serviceList.add("splan3");
		serviceList.add("splan4");
		serviceList.add("splan5");

		service = new String[]{"splan1","splan2","splan3","splan4","splan5"};				
		return "populate";
	}

	public String execute() throws Exception{
		String url = "jdbc:mysql://localhost:3306/";
  		String dbName = "cop";
 		String driverName = "com.mysql.jdbc.Driver";
 		String username = "root";
  		String Password = "";
 		Connection con=null;
		Statement stmt=null;
  		try{
  		Class.forName(driverName).newInstance();
  		con=DriverManager.getConnection(url+dbName, username,Password);
  		stmt=con.createStatement();
  		}
  		catch(Exception e){
  		System.out.println(e.getMessage());
  		}
		Map session = ActionContext.getContext().getSession();
 		userId=(String)session.get("User");

		String[] splanx=getService();
		String[] splan={"splan1","splan2","splan3","splan4","splan5"};
		int i;
		int j=0;
		for(i=0;i<5;i++)
		{
			if(splan[i].equals(splanx[j]))
			j++;
			else
			splan[i]="0";
		}
		stmt = con.createStatement();
		
  		stmt.executeUpdate("INSERT INTO serviceplan(id,splan1,splan2,splan3,splan4,splan5) VALUES('"+userId+"','"+splan[0]+"','"+splan[1]+"','"+splan[2]+"','"+splan[3]+"','"+splan[4]+"')");
		
		//stmt.executeUpdate("INSERT INTO serviceplan(splan5) VALUES('"+splan[4]+"')");
		return SUCCESS;
	}

	
	public String[] getDefaultService(){
		return new String [] {"splan1", "splan5"};
	
	}
	public String[] getService() {
		return service;
	}

	public void setService(String[] service) {
		
		this.service = service;
	}

	public ArrayList<String> getServiceList() {
		return serviceList;
	}

	public void setServiceList(ArrayList<String> serviceList) {
		this.serviceList = serviceList;
	}

	}
