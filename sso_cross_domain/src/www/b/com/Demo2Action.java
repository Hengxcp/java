package www.b.com;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import www.b.com.utils.Demo2Tool;


public class Demo2Action extends ActionSupport {
	 private String gotoUrl;
	 private String username;
	 private String password;
	 private String path;
	 
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGotoUrl() {
		return gotoUrl;
	}
	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String doLogin() {
		Map<String,String> map=new HashMap<String,String>();
		map.put("username",username);
		map.put("password",password);
		String result=Demo2Tool.doGet("http://www.x.com:8080/sso_cross_domain/sso/doLogin.action", map);
		if(result.equals("1")) {
			return SUCCESS;
		}
		
		return LOGIN;
		
	}
	
	public String main() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("ssocookie")) {
					Map<String,String> map=new HashMap<String,String>();
					map.put("cookieName",cookie.getName());
					map.put("cookieValue",cookie.getValue());
					 String result=Demo2Tool.doGet("http://www.x.com:8080/sso_cross_domain/sso/checkCookie.action",
							map);
					 if(result.equals("1")) {
						 return SUCCESS;
					 }
				}
			}
		}
		path="demo2";
		gotoUrl="http://www.b.com:8080/sso_cross_doamin/demo2/main.action";
		return LOGIN;
	}
	public void addCookie() {
		Cookie cookie=new Cookie("ssocookie","sso");
		cookie.setPath("/");
		HttpServletResponse response=ServletActionContext.getResponse();
		response.addCookie(cookie);
	}

}
