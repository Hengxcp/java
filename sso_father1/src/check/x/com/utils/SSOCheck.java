package check.x.com.utils;

public class SSOCheck {
	public static final String USERNAME ="user";
	public static final String PASSWORD="123";
	public static boolean checkLogin(String username,String password) {
		if(username.equals(USERNAME)&&password.equals(PASSWORD)) {
			return true;
		}
		return false;
	}
	public static boolean checkCookie(String cookieName,String cookieValue) {
		//这个参数可以获取浏览器下的所有cookie

		if (cookieName.equals("ssocookie") && cookieValue.equals("sso")) {
			return true;
		}

		return false;

	}

}
