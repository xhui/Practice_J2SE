package ex.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ImitateDigest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update("a".getBytes());
			byte[] hash = digest.digest();
			String d = "";
			for (int i = 0; i < hash.length; i++) {
				int v = hash[i] & 0xFF;
				if (v < 16) {
					d += "0";
				}
				d += Integer.toString(v, 16).toUpperCase();
			}
			System.out.println(d);

			System.out.println();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
