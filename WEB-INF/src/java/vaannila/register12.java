/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vaannila;

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

/**
 *
 * @author Meyyappan Muthuraman
 */
public class register12 extends ActionSupport {

    private String userName;
    private String password;
    private String companyname;
    private int faxnumber;
    private String emailid;
    private String address;
    private String queries;
    private String comments;

    public register12() {
    }

    public String execute() throws Exception {
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
  String uname=getUserName();
  String pws=getPassword();
  int faxno=getFaxnumber();
  String query=getQueries();
  String cms=getComments();
  String add=getAddress();
  String email=getEmailid();
  String cname=getCompanyname();
  stmt = con.createStatement();
  int val = stmt.executeUpdate("INSERT INTO record(name,faxno,address,emailid,query,comments,id,passwd) VALUES('"+cname+"','"+faxno+"','"+add+"','"+email+"','"+query+"','"+cms+"','"+uname+"','"+pws+"')");

  if(val == 0){
  return ERROR;
  }
  else{
  return SUCCESS;
  }
  }

    public void validate() {
        if (getUserName().length() == 0) {
            addFieldError("userName", "User Name is required");
        } 
        if (getPassword().length() == 0) {
            addFieldError("password", getText("password.required"));
        }
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
	public String getCompanyname() {
		return companyname;
	}	

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public int getFaxnumber() {
		return faxnumber;
	}

	public void setFaxnumber(int faxnumber) {
		this.faxnumber = faxnumber;
	}

	public String getEmailid() {
		return emailid;
	}
	
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQueries() {
		return queries;
	}

	public void setQueries(String queries) {
		this.queries = queries;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	}