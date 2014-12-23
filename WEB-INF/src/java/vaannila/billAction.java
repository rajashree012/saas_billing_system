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
public class billAction extends ActionSupport {

	private double amount;

   public billAction() {
    }
    public String execute() throws Exception{
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
		int calls=0;
		String userId;
		amount=0;
		amount=amount+400000;
		Map session = ActionContext.getContext().getSession();
		userId=(String)session.get("User");
		String str="SELECT * FROM calls";
		rst=stmt.executeQuery(str);

		while(rst.next())
		{
			if((userId.equals(rst.getString("id"))))
			{
				calls++;
			}
		}
		if(calls>0)
		{	
			if(calls<=500)
			amount=amount+calls*5;
			else if(calls>500)
			amount=amount+500*5;
		}
		calls=calls-500;
		if(calls>0)
		{
			if(calls<=500)
			amount=amount+calls*4.5;
			else if(calls>500)
			amount=amount+500*4.5;
		}
		calls=calls-500;
		if(calls>0)
		{
			if(calls<=1000)
			amount=amount+calls*3.5;
			else if(calls>1000)
			amount=amount+1000*3.5;
		}
		calls=calls-1000;
		if(calls>0)
		{
			amount=amount+calls*3;
		}
	}
	catch(Exception e){
	System.out.println(e.getMessage());
	}
		return SUCCESS;

}

public double getAmount() {
        return amount;
    }

    /**
     * @param userName the userName to set
     */
    public void setAmount(double amount) {
        this.amount = amount;

}
}  