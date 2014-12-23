package vaannila;
import javax.servlet.http.HttpSession;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.*;

public class logoutAction extends ActionSupport {
  public String execute() throws Exception { 
  Map session = ActionContext.getContext().getSession();
  session.remove("User"); 
  return SUCCESS;
  }
}