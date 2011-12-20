package ex.permission;

import java.security.Permission;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordCheckPermission extends Permission {
	public static void main(String[] args) {
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		String strIn = null;
		try {
			// System.out.println("pls input a word:");
			// strIn = br.readLine();
			strIn = "food is good";
			WordCheckPermission permission = new WordCheckPermission(strIn,
					"insert");
			SecurityManager manager = System.getSecurityManager();
			if (manager != null) {
				manager.checkPermission(permission);
				System.out.print("yours are: " + strIn);
			} else
				System.out.println("manager is null");
			// } catch (IOException e) {
			// e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("the words '" + strIn + "' are not allowed");
			e.printStackTrace();
		}
	}

	private static final long serialVersionUID = -7097651032247376693L;
	private String action;

	public WordCheckPermission(String target, String action) {
		super(target);
		this.action = action;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			//[start]
			return false;
			
		if (!getClass().equals(obj.getClass()))
			return false;
		WordCheckPermission permission = (WordCheckPermission) obj;
		if (!action.equals("insert"))
			return getName().equals(permission.getName());
		else if (action.equals("avoid"))
			return badWordSet().equals(permission.badWordSet());
		else
			return false;
		//[end]
	}

	@Override
	public String getActions() {
		return action;
	}

	@Override
	public int hashCode() {
		return getName().hashCode() + action.hashCode();
	}

	@Override
	public boolean implies(Permission permission) {
		if (!(permission instanceof WordCheckPermission))
			return false;
		WordCheckPermission b = (WordCheckPermission) permission;
		if (action.equals("insert")) {
			return b.action.equals("insert")
					&& getName().indexOf(b.getName()) >= 0;
		} else if (action.equals("avoid")) {
			if (b.action.equals("avoid"))
				return b.badWordSet().containsAll(badWordSet());
			else if (b.action.equals("insert")) {
				for (String badWord : badWordSet()) {
					if (b.getName().indexOf(badWord) >= 0)
						return false;
				}
				return true;
			} else
				return false;
		} else
			return false;
	}

	public Set<String> badWordSet() {
		Set<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(getName().split(",")));
		return set;
	}
}
