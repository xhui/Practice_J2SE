package ex.auth;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class AuthPrac {
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		try {
			LoginContext context = new LoginContext("Login1");
			context.login();
			System.out.println("in");
			Subject subject = context.getSubject();
			Object result = Subject.doAsPrivileged(subject, new SyspropAction(
					"user.home"), null);
			System.out.println(result);
			context.logout();
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
}
