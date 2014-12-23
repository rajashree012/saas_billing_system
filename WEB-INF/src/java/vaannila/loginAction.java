package vaannila;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.lang.*;
import java.lang.String;
import java.util.Random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class loginAction extends ActionSupport {
  private String userId;
  private String password;
  public String execute() throws Exception{

  if (getUserId().length() == 0) {
            addFieldError("userId", "User Name is required");
        } 
        else if (getPassword().length() == 0) {
            addFieldError("password", getText("password.required"));
        }
	else
	{
		String url = "jdbc:mysql://localhost:3306/";
  		String dbName = "cop";
  String driverName = "com.mysql.jdbc.Driver";
  String username = "root";
  String Password = "";
  Connection con=null;
  ResultSet rst=null;
  Statement stmt=null;
  try{
  Class.forName(driverName).newInstance();
  con=DriverManager.getConnection(url+dbName, username,Password);
  stmt=con.createStatement();
  String uname=getUserId();
  String pws=getPassword();
  String str="SELECT * FROM record";
	rst=stmt.executeQuery(str);
	while(rst.next())
	{
		if((uname.equals(rst.getString("id")))&&(pws.equals(rst.getString("passwd"))))
		{
			Map session = ActionContext.getContext().getSession();
 			 session.put("User",userId);
			return SUCCESS;
		}
		else if((uname.equals(rst.getString("id"))))
				return ERROR;
		
		
	}
	rst.close();
	stmt.close();
	con.close();
	}
  catch(Exception e){
  System.out.println(e.getMessage());
  }
		
	}
	return INPUT;
  }

  public String logout() throws Exception {

  Map session = ActionContext.getContext().getSession();
  session.remove("User");
  return SUCCESS;
  }

  public String getPassword() {
  return password;
  }

  public void setPassword(String password) {
  this.password = password;
  }

  public String getUserId() {
  return userId;
  }

  public void setUserId(String userId) {
  this.userId = userId;
  }
}