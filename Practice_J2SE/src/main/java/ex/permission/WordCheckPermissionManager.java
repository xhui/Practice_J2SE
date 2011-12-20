package ex.permission;

import java.io.FilePermission;
import java.security.Permission;

public class WordCheckPermissionManager extends SecurityManager {

	public static void main(String[] args) {

	}

	@Override
	public void checkPermission(Permission perm) {
		if (perm instanceof FilePermission && "read".equals(perm.getActions())) {
			// if(containsBadWords(perm.getName()))
			throw new SecurityException(perm.getName());
		} else
			super.checkPermission(perm);
	}
}