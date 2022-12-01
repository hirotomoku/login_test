package common;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {

	public static void main(String[] args) {
		try {
			Properties property = new Properties();
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.auth", "true");
			property.put("mail.smtp.starttls.enable", "true");
			property.put("mail.smtp.host", "smtp.gmail.com");
			property.put("mail.smtp.port", "587");
			property.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(property, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("mokutest2022@gmail.com", "fkzummifyprqjpli");
				}
			});
			
			MimeMessage mimeMessage = new MimeMessage(session);
			InternetAddress toAddress = new InternetAddress("hirotomoku@gmail.com", "俺");
			mimeMessage.setRecipient(Message.RecipientType.TO, toAddress);
			InternetAddress fromAddress = new InternetAddress("mokutest2022@gmail.com", "俺");
			mimeMessage.setFrom(fromAddress);
			mimeMessage.setSubject("title", "ISO-2022-JP");
			mimeMessage.setText("messageaa", "ISO-2022-JP");
			Transport.send(mimeMessage);
			System.out.println("メール送信が完了しました。");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	}

