package space.univl.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import space.univl.encriptar.EncryptUtil;
import space.univl.mail.EmailService;

@WebServlet("/solicitarPassword")
public class SolicitarPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = -5874732015721483588L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");

		System.out.println("correo: " + email);

		String token = EncryptUtil.generarToken(email);

		if (token != null) {

			EmailService emailService = new EmailService();
			emailService.setTema("Recuperar contraseña");
			emailService.setMensaje("Bienvenido a tu plataforma "
					+ "digital UNIVL.<br/>Para obtener una nueva contraseña válida "
					+ "para tu cuenta da click en el siguiente link: "
					+ "<a href=\"" + "http://localhost:9080/univlspace-site/generarPassword" + "?email=" + email + "&c=" + token + "\">recuperar Contraseña</a>");
			emailService.sendMail(email);
			
			req.setAttribute("respuesta", "Enviado E-mail con instrucciones para recuperar contraseña.");
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} else {
			
			req.setAttribute("respuesta", "E-mail no es válido.");
			
			req.getRequestDispatcher("recuperar.jsp").forward(req, resp);
			
		}
		
	}

}
