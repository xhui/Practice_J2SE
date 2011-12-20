package ex.jaas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ex.auth.SyspropAction;

public class JAASFrame extends JFrame {

	private static final long serialVersionUID = -3939770261993765049L;
	private JTextField userName;
	private JPasswordField password;
	private JTextField propertyName;
	private JTextField propertyValue;

	public JAASFrame() {
		setTitle("Jaas_Test");
		userName = new JTextField(20);
		password = new JPasswordField(20);
		propertyName = new JTextField(20);
		propertyValue = new JTextField(20);

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2));
		panel.add(new JLabel("username: "));
		panel.add(userName);
		panel.add(new JLabel("password: "));
		panel.add(password);
		panel.add(propertyName);
		panel.add(propertyValue);
		add(panel, BorderLayout.CENTER);

		JButton btValue = new JButton("get value");
		btValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getValue();
			}
		});
		JPanel btPanel = new JPanel();
		btPanel.add(btValue);
		add(btPanel, BorderLayout.SOUTH);
		pack();
	}

	public void getValue() {
		try {
			LoginContext context = new LoginContext("Login1",
					new SmplCallBackHandler(userName.getText(), password
							.getPassword()));
			context.login();
			Subject subject = context.getSubject();
			propertyValue.setText(""
					+ Subject.doAsPrivileged(subject, new SyspropAction(
							propertyName.getText()), null));
			context.logout();
		} catch (LoginException e) {
			JOptionPane.showMessageDialog(this, e);
		}
	}
}
