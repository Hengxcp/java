package com.sso;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.util.SSOCheck;

public class SSOAction extends ActionSupport{

		private String username;
		private String password;
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




		public String doLogin() {
			 boolean ok =SSOCheck.checkLogin(username, password);
			 if(ok) {
				 Cookie cookie =new Cookie("ssocookie","sso");
				 //给cookie设置路径
				 cookie.setPath("/");//在该域下面localhost都是可见的
				 HttpServletResponse response =ServletActionContext.getResponse();
				 response.addCookie(cookie);
				 return SUCCESS;
			 }
			
			
			return null;
			
		}
		
		
		
		
		/**
		 * @return the username
		 */
		public String getUsername() {
			return username;
		}
		/**
		 * @param username the username to set
		 */
		public void setUsername(String username) {
			this.username = username;
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
		
		
		

}
