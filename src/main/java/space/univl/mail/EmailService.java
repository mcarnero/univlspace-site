package space.univl.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {
	
	private String tema;
	private String mensaje;

	public void sendMail(String email) {
		
		String from = "cartago343@gmail.com";
		
		final String username = "cartago343@gmail.com";
		final String password = "carspa343";
		
		String host = "smtp.gmail.com";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.ssl.trust", host);
		
		/*
		 * Login a nuestra cuenta
		 */
		Session session = Session.getInstance(props, new Authenticator() {
			
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from));
			
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			message.setSubject(tema);
			message.setContent(mensaje, "text/html");
			
			Transport.send(message);
			
			System.out.println("Email de confirmación enviado de forma exitosa " + email);
			
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setTema(String tema) {
		this.tema = tema;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
