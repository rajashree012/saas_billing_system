/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaannila;

import com.opensymphony.xwork2.ActionSupport;
import java.io.*;
import java.lang.String;
import java.util.Random;
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
import java.util.Date;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;
import java.lang.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author Meyyappan Muthuraman
 */
public class serviceselectAction extends ActionSupport {

   private String[] selectservice=new String[5];
	private String userId;
	
	private ArrayList<String> selectserviceList;
	
	
	public String populate() throws Exception{

		String url = "jdbc:mysql://localhost:3306/";
  		String dbName = "cop";
 		String driverName = "com.mysql.jdbc.Driver";
 		String username = "root";
  		String Password = "";
 		Connection con=null;
		Statement stmt=null;
		ResultSet rst=null;

  		try{
  		Class.forName(driverName).newInstance();
  		con=DriverManager.getConnection(url+dbName, username,Password);
  		stmt=con.createStatement();
  		}
  		catch(Exception e){
  		System.out.println(e.getMessage());
  		}
		stmt = con.createStatement();
		Map session = ActionContext.getContext().getSession();
		//String userId;
 		userId=(String)session.get("User");

		String[] services=new String[5];
		String str="SELECT * FROM serviceplan";
		rst=stmt.executeQuery(str);
		while(rst.next())
		{
		if((userId.equals(rst.getString("id"))))
		{
			services[0]=rst.getString("splan1");
			services[1]=rst.getString("splan2");	
			services[2]=rst.getString("splan3");	
			services[3]=rst.getString("splan4");	
			services[4]=rst.getString("splan5");				
		}
				
		
	}
	rst.close();
	stmt.close();
	con.close();


		selectserviceList = new ArrayList<String>();
		if(!(services[0].equals("0")))
		selectserviceList.add("splan1");
		if(!(services[1].equals("0")))
		selectserviceList.add("splan2");
		if(!(services[2].equals("0")))
		selectserviceList.add("splan3");
		if(!(services[3].equals("0")))
		selectserviceList.add("splan4");
		if(!(services[4].equals("0")))
		selectserviceList.add("splan5");

		selectservice = new String[]{"splan1","splan2","splan3","splan4","splan5"};				
		return "populate";
	}


    public serviceselectAction() {
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
		//Date date=new Date(session.getLastAccessedTime());
		Calendar cal = Calendar.getInstance();
    	cal.getTime();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String date=sdf.format(cal.getTime());
		String[] splanx=getSelectservice();
		stmt = con.createStatement();
		  		stmt.executeUpdate("INSERT INTO calls(id,servicenumber,time) VALUES('"+userId+"','"+splanx[0]+"','"+date+"')");
		
		//stmt.executeUpdate("INSERT INTO serviceplan(splan5) VALUES('"+splan[4]+"')");
	return SUCCESS;
  }
	public String[] getDefaultSelectervice(){
		return new String [] {"splan1", "splan5"};
	
	}
	public String[] getSelectservice() {
		return selectservice;
	}

	public void setSelectservice(String[] selectservice) {
		
		this.selectservice = selectservice;
	}

	public ArrayList<String> getSelectserviceList() {
		return selectserviceList;
	}

	public void setSelectserviceList(ArrayList<String> selectserviceList) {
		this.selectserviceList = selectserviceList;
	}

  }

  