package demo2.x.com;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import demo2.x.com.utils.Demo2Tool;

public class Demo2Action extends ActionSupport {
	 private String gotoUrl;
	/**
	 * @return the gotoUrl
	 */
	public String getGotoUrl() {
		return gotoUrl;
	}
	/**
	 * @param gotoUrl the gotoUrl to set
	 */
	public void setGotoUrl(String gotoUrl) {
		this.gotoUrl = gotoUrl;
	}
	public String main() {
		HttpServletRequest request=ServletActionContext.getRequest();
		Cookie[] cookies=request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("ssocookie")) {
					 String result=Demo2Tool.doGet("http://check.x.com:8080/sso_father1/sso/checkCookie.action",
							 cookie.getName(), cookie.getValue());
					 if(result.equals("1")) {
						 return SUCCESS;
					 }
				}
			}
		}
		gotoUrl="http://demo2.x.com:8080/sso_father1/demo2/main.action";
		return LOGIN;
	}

}
