package space.univl.servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import space.univl.db.UsuarioDB;
import space.univl.encriptar.EncryptUtil;
import space.univl.mail.EmailService;

@WebServlet("/generarPassword")
public class GenerarPasswordServlet extends HttpServlet {

	private static final long serialVersionUID = -6355329355636434087L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String token = req.getParameter("c");
		
		if (comprobarToken(email, token)) {
			
			System.out.println("Token correcto");
			
			String password = generarPassword();
			
			EmailService emailService = new EmailService();
			emailService.setTema("Nueva contraseña");
			emailService.setMensaje("Bienvenido a tu plataforma "
					+ "digital UNIVL.<br/>Correo electrónico: " + email + "<br/>"
					+ "Nueva Password: " + password);
			emailService.sendMail(email);
			
			UsuarioDB usuarioDB = new UsuarioDB();
			usuarioDB.cambiarPassword(email, password);
			
			req.setAttribute("respuesta", "Enviado E-mail con nueva contraseña.");
			
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		} else {
			
			System.out.println("Token incorrecto");
			
			req.setAttribute("respuesta", "Problema recuperando su contraseña.");
			
			req.getRequestDispatcher("recuperar.jsp").forward(req, resp);
			
		}
		
	}
	
	public boolean comprobarToken(String email, String tokenRecibido) {
		
		String tokenGenerado = EncryptUtil.generarToken(email);
		
		if(tokenGenerado.equals(tokenRecibido)) {
			return true;
		}
		
		return false;
	}
	
	public String generarPassword() {
		
		String password = "";
		int n;
		
		Random num = new Random();
		
		for (int i=0; i<5; i++) {
			
			do {
				n = num.nextInt(90)+33;
			} while (n==34 || n==39 || n==44 || n==46 || n==94 || n==96);
			
			password = password + (char)n;
			
		}

		System.out.println(password);
		
		return password;
	}

}
