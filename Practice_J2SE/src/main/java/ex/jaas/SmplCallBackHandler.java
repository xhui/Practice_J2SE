package ex.jaas;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class SmplCallBackHandler implements CallbackHandler {
	private String username;
	private char[] password;

	public SmplCallBackHandler(String username, char[] password) {
		this.username = username;
		this.password = password;
	}

	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			if (callback instanceof NameCallback) {
				((NameCallback) callback).setName(username);
			} else if (callback instanceof PasswordCallback) {
				((PasswordCallback) callback).setPassword(password);
			}
		}
	}
}
