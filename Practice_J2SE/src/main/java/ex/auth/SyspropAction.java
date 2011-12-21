package ex.auth;

import java.security.PrivilegedAction;

public class SyspropAction implements PrivilegedAction<Object>
{
	public static void main(String[] args)
	{
		System.out.println(System.getProperty("user.home"));
	}

	public SyspropAction(String key)
	{
		this.key = key;
	}

	public Object run()
	{
		return System.getProperty(key);
	}

	private String	key;
}
