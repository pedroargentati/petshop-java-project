package br.com.fiap.cp5.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.cp5.dao.ClienteDAOBD;
import br.com.fiap.cp5.dao.ClientePFDAOBD;
import br.com.fiap.cp5.dao.ClientePJDAOBD;
import br.com.fiap.cp5.enumeracao.TipoCliente;
import br.com.fiap.cp5.model.ClienteVo;

@WebServlet(urlPatterns = "/clientedelete")
public class ClienteDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ClienteDAOBD clienteDAO = new ClienteDAOBD();
		ClientePFDAOBD clientePfDAO = new ClientePFDAOBD();
		ClientePJDAOBD clientePjDAO = new ClientePJDAOBD();
		RequestDispatcher dispatcher = req.getRequestDispatcher("clientedelete.jsp");
		
		Integer id_cliente = Integer.valueOf(req.getParameter("id_cliente"));
		
		try {
			ClienteVo cliente = clienteDAO.obterClientePorChave(id_cliente);
			if (cliente != null) {
				if (req.getParameter("tp_cliente").equalsIgnoreCase(TipoCliente.PESSOAJURIDICA.getDescricao())) {
					if (clientePjDAO.obterClientePJPorChave(id_cliente) != null) {
						clientePjDAO.excluirClientePJ(id_cliente);
					}
				} else {
					if (clientePfDAO.obterClientePFPorChave(id_cliente) != null) {
						clientePfDAO.excluirClientePF(id_cliente);
					}
				}
				clienteDAO.excluirCliente(cliente);
				dispatcher.forward(req, resp);
			} else {
				dispatcher = req.getRequestDispatcher("cliente.jsp");
				PrintWriter out = resp.getWriter();
				out.print("<h3 style=\"color: red;\">Registro não encontrado</h3>.");
			}
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
