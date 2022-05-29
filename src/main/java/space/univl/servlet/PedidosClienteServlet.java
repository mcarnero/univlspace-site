package space.univl.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import space.univl.model.Usuario;

@WebServlet("/pedidosCliente")
public class PedidosClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 7508717261137757453L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		
		if (session != null) {
			
			Usuario usuario =  (Usuario) session.getAttribute("user");
			
			if(usuario != null) {
				
				System.out.println("Usuario: " + usuario.getNombreCompleto());
				req.setAttribute("mensaje", "Mostrar pedidos de: " + usuario.getNombreCompleto());
				
			} else {
				req.setAttribute("mensaje", "Logearse primero, por favor");
			}
			
		} else {
			req.setAttribute("mensaje", "Logearse primero, por favor");
		}
		
		req.getRequestDispatcher("pedidosCliente.jsp").forward(req, resp);
		
	}

}
