package ex.jaas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class SmplLoginModule implements LoginModule {
	private Subject subject;
	private CallbackHandler callBackHandler;
	private Map<String, ?> sharedState;
	private Map<String, ?> options;

	public boolean abort() throws LoginException {
		return true;
	}

	public boolean commit() throws LoginException {
		return true;
	}

	public void initialize(Subject subject, CallbackHandler callbackHandler,
			Map<String, ?> sharedState, Map<String, ?> options) {
		this.subject = subject;
		this.callBackHandler = callbackHandler;
		this.sharedState = sharedState;
		this.options = options;
	}

	public boolean login() throws LoginException {
		if (callBackHandler == null)
			throw new LoginException("no handler");
		NameCallback nameCall = new NameCallback("username: ");
		PasswordCallback passCall = new PasswordCallback("password: ", false);
		try {
			callBackHandler.handle(new Callback[] { nameCall, passCall });
		} catch (UnsupportedCallbackException e) {
			throw new LoginException("UnsupportedCallbackException");
		} catch (IOException e) {
			throw new LoginException("IOException in callback");
		}
		return checkLogin(nameCall.getName(), passCall.getPassword());
	}

	public boolean logout() throws LoginException {
		return true;
	}

	private boolean checkLogin(String userName, char[] password)
			throws LoginException {
		try {
			Scanner in = new Scanner(new FileReader("" + options.get("pwfile")));
			while (in.hasNextLine()) {
				String[] inputs = in.nextLine().split("\\|");
				if (inputs[0].equals(userName)
						&& Arrays.equals(inputs[1].toCharArray(), password)) {
					String role = inputs[2];
					Set<Principal> principals = subject.getPrincipals();
					principals.add(new SmplPrincipal("username", userName));
					principals.add(new SmplPrincipal("role", role));
					return true;
				}
			}
			in.close();
			return false;
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			throw new LoginException("cannot open password file");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new LoginException();
		}
	}

}
