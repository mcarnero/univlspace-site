package space.univl.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import space.univl.db.UsuarioDB;
import space.univl.encriptar.EncryptUtil;
import space.univl.model.Usuario;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 8271853448569548495L;
	
	Logger log = Logger.getLogger(LoginServlet.class.getName());

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("usuario");
		String password = req.getParameter("password");
		
		log.info("Usuario entrando a sistema: " + email);
		
		UsuarioDB usuarioDB = new UsuarioDB();
		String respuesta = null;
		String pagina = null;
		
		Usuario usuario = usuarioDB.login(email);
		
		if (usuario == null) {
			respuesta = "Usuario no existe.";
			pagina = "index.jsp";
		} else if (!EncryptUtil.decode(usuario.getPassword()).equals(password)) {
			respuesta = "Password incorrecto.";
			pagina = "index.jsp";
		} else if (!usuario.isActivo()) {
			respuesta = "Usuario no se encuentra activo, activar desde tu email.";
			pagina = "index.jsp";
		} else {
			respuesta = "Acceso exitoso.";
			req.setAttribute("usuario", usuario);
			
			HttpSession session = req.getSession();
			session.setAttribute("user", usuario);
			
			pagina = "home.jsp";
		}
		
		req.setAttribute("respuesta", respuesta);
		req.getRequestDispatcher("/" + pagina).forward(req, resp);
	}
}
