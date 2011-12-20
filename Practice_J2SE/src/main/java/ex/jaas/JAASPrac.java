/**
 * 
 */
package ex.jaas;

import javax.swing.JFrame;

/**
 * @author maxxu
 * 
 */
public class JAASPrac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager());
		JFrame frame = new JAASFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
