package ex.mail;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.AuthenticationFailedException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class JavaMail
{

	private String mailTo = null;
	private String mailFrom = null;
	private String smtpHost = null;
	private String subject;
	private String msgContent;
	private String messageContentMimeType = "text/html; charset=gb2312";
	private String mailccTo = null;

	private void fillMail(Session session, MimeMessage msg) throws IOException, MessagingException
	{

		if (mailFrom != null)
		{
			msg.setFrom(new InternetAddress(mailFrom));
			System.out.println("发送人Mail地址：" + mailFrom);
		} else
		{
			System.out.println("没有指定发送人邮件地址！");
			return;
		}

		if (mailTo != null)
		{
			InternetAddress[] address = InternetAddress.parse(mailTo);
			msg.setRecipients(Message.RecipientType.TO, address);
			System.out.println("收件人Mail地址：" + mailTo);
		} else
		{
			System.out.println("没有指定收件人邮件地址！");
			return;
		}

		if (mailccTo != null)
		{
			InternetAddress[] ccaddress = InternetAddress.parse(mailccTo);
			System.out.println("CCMail地址：" + mailccTo);
			msg.setRecipients(Message.RecipientType.CC, ccaddress);
		}

		msg.setSubject(subject);
		InternetAddress[] replyAddress = { new InternetAddress(mailFrom) };
		msg.setReplyTo(replyAddress);

		// create and fill the first message part
		MimeBodyPart mBodyContent = new MimeBodyPart();
		if (msgContent != null)
		{
			mBodyContent.setContent(msgContent, messageContentMimeType);
		} else
		{
			mBodyContent.setContent("", messageContentMimeType);
		}
		Multipart mPart = new MimeMultipart();
		mPart.addBodyPart(mBodyContent);
		msg.setContent(mPart);
		msg.setSentDate(new Date());
	}

	/**
	 * 发送e_mail，返回类型为int 当返回值为0时，说明邮件发送成功 当返回值为3时，说明邮件发送失败
	 */

	public int sendMail() throws IOException, MessagingException
	{
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.auth", "true");
		MailAuthenticator auth = new MailAuthenticator();
		Session session = Session.getInstance(props, auth);
		MimeMessage msg = new MimeMessage(session);
		Transport trans = null;
		try
		{
			fillMail(session, msg);
			// send the message
			trans = session.getTransport("smtp");
			try
			{
				trans.connect(smtpHost, MailAuthenticator.HUAWEI_MAIL_USER,
						MailAuthenticator.HUAWEI_MAIL_PASSWORD);

			} catch (AuthenticationFailedException e)
			{
				e.printStackTrace();
				System.out.println("连接邮件服务器错误：");
				return 3;
			} catch (MessagingException e)
			{
				System.out.println("连接邮件服务器错误：");
				return 3;
			}
			Transport.send(msg);
			trans.close();
		} catch (MessagingException mex)
		{
			System.out.println("发送邮件失败：");
			mex.printStackTrace();
			Exception ex = null;
			if ((ex = mex.getNextException()) != null)
			{
				System.out.println(ex.toString());
				ex.printStackTrace();
			}
			return 3;
		} finally
		{
			try
			{
				if (trans != null && trans.isConnected())
				{
					trans.close();
				}
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}
		}
		System.out.println("发送邮件成功！");
		return 0;
	}

	public void setMailccTo(String ccto)
	{
		mailccTo = ccto;
	}

	public void setMailFrom(String from)
	{
		mailFrom = from;
	}

	public void setMailTo(String to)
	{
		mailTo = to;
	}

	public void setMessageContentMimeType(String mimeType)
	{
		messageContentMimeType = mimeType;
	}

	public void setMsgContent(String content)
	{
		msgContent = content;
	}

	public void setSMTPHost(String host)
	{
		smtpHost = host;
	}

	public void setSubject(String sub)
	{
		subject = sub;
	}

	public static void main(String[] argv) throws Exception
	{
		for (int i = 0; i < 10; i++)
		{
			JavaMail sm = new JavaMail();
			sm.setSMTPHost("172.16.15.98");
			sm.setMailFrom("max@texe.com");
			sm.setMailTo("icegreen@texe.com");
			sm.setMsgContent("This is a test mail for testing");
			sm.setSubject("标题" + i);
			sm.sendMail();
		}
	}

}

class MailAuthenticator extends Authenticator
{
	public static String HUAWEI_MAIL_USER = "max";
	public static String HUAWEI_MAIL_PASSWORD = "max";

	protected PasswordAuthentication getPasswordAuthentication()
	{
		return new PasswordAuthentication(HUAWEI_MAIL_USER, HUAWEI_MAIL_PASSWORD);
	}

}
