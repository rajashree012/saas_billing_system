package vaannila;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;
import java.lang.*;

public class rajAction extends ActionSupport{
	String user1; 
    public String execute() throws Exception{
Map session = ActionContext.getContext().getSession();
 user1=(String)session.get("User");
  
  return SUCCESS;
  
  }
 public String getUser1() {
  return user1;
  }

  public void setUser1(String user1) {
  this.user1 = user1;
  }

  
}