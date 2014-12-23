package vaannila;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.lang.*;

import java.lang.*;
import java.lang.String;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Bplan extends ActionSupport {

    private String userId;
    private String bplan;    
    public Bplan() {
    }

    public String execute() throws Exception {
  		String url = "jdbc:mysql://localhost:3306/";
  		String dbName = "cop";
  String driverName = "com.mysql.jdbc.Driver";
  String username = "root";
  String Password = "";
  
  Connection con=null;
  Statement stmt=null;
	int val=0;
 
  try{
  Class.forName(driverName).newInstance();
  con=DriverManager.getConnection(url+dbName, username,Password);
  stmt=con.createStatement();
  FileInputStream fstream = new FileInputStream("write.txt");
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
   while ((userId = br.readLine()) != null);
   in.close();
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
  Map session = ActionContext.getContext().getSession();
  userId=(String)session.get("User");

  String billplan=getBplan();
  stmt = con.createStatement();
   val = stmt.executeUpdate("INSERT INTO bplans(id,bplan) VALUES('"+userId+"','"+billplan+"')");
  stmt.close();
	con.close();
	
  
  return SUCCESS;
  
  }

    
  public String getBplan() {
		return bplan;
}

public void setBplan(String bplan) {
this.bplan = bplan;
  }
    
}