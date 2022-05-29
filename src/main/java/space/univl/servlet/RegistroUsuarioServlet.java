package space.univl.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import space.univl.db.UsuarioDB;
import space.univl.mail.EmailService;
import space.univl.model.Usuario;

@WebServlet("/registrarUsuario")
public class RegistroUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 3341307523240022133L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombre = req.getParameter("nombre");
		String apellidoPaterno = req.getParameter("apellidoPaterno");
		String apellidoMaterno = req.getParameter("apellidoMaterno");
		String email = req.getParameter("email");
		String telefono = req.getParameter("telefono");
		String pais = req.getParameter("pais");
		String password = req.getParameter("password");
		
		Usuario usuario = new Usuario();
		usuario.setNombre(nombre);
		usuario.setApellidoPaterno(apellidoPaterno);
		usuario.setApellidoMaterno(apellidoMaterno);
		usuario.setEmail(email);
		usuario.setTelefono(telefono);
		usuario.setPais(pais);
		usuario.setPassword(password);
		
		UsuarioDB usuarioDB = new UsuarioDB();
		String respuesta = usuarioDB.crearUsuario(usuario);
		
		req.setAttribute("respuesta", respuesta);
		
		EmailService emailService = new EmailService();
		emailService.setTema("Activación de cuenta");
		emailService.setMensaje("Bienvenido " + usuario.getNombreCompleto() + " a tu plataforma "
					+ "digital, para activar tu cuenta da click en el siguiente link: "
					+ "<a href=\"" + "http://localhost:9080/univlspace-site/activar" + "?email=" + usuario.getEmail() + "\">Activar mi cuenta</a>");
		emailService.sendMail(usuario.getEmail());
		
		System.out.println("Usuario creado de forma exitosa");
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
