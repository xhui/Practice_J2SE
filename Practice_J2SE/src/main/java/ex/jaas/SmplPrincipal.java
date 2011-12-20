package ex.jaas;

import java.security.Principal;

public class SmplPrincipal implements Principal {
	private String desc;
	private String value;

	public SmplPrincipal(String desc, String value) {
		this.desc = desc;
		this.value = value;
	}

	public String getName() {
		return desc + "=" + value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SmplPrincipal other = (SmplPrincipal) obj;
		return getName().equals(other.getName());
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

}
