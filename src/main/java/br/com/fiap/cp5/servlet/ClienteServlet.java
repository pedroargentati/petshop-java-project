package br.com.fiap.cp5.servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import br.com.fiap.cp5.model.ClientePJVo;
import br.com.fiap.cp5.model.ClientePfVo;
import br.com.fiap.cp5.model.ClienteVo;

@WebServlet(urlPatterns = "/cliente")
public class ClienteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		ClienteDAOBD clienteDAO = new ClienteDAOBD();
		ClientePFDAOBD clientePfDAO = new ClientePFDAOBD();
		ClientePJDAOBD clientePjDAO = new ClientePJDAOBD();
		ClienteVo cliente = this.createVo(req);

		try {
			if (cliente != null) {
				clienteDAO.inserirCliente(cliente);
				if (cliente.getTp_cliente().equalsIgnoreCase(TipoCliente.PESSOAFISICA.getDescricao())) {
					ClientePfVo clientePf = this.createPFVo(req, cliente.getId_cliente());
					if (clientePf != null) {
						clientePfDAO.cadastrarClientePf(clientePf);
					}
				} else {
					ClientePJVo clientePj = this.createPJVo(req);
					System.out.println(clientePj);
					if (clientePj != null) {
						clientePjDAO.cadastrarClientePJ(clientePj);
						this.fillFormPj(clientePj, req);
					}
				}
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("sucessocliente.jsp");
		this.fillForm(cliente, req);
		dispatcher.forward(req, resp);
	}

	private ClienteVo createVo(HttpServletRequest req) {
		ClienteVo cliente = new ClienteVo();

		cliente.setId_cliente(1);
		cliente.setId_cidade(1);
		cliente.setNome_cliente(req.getParameter("nome_cliente"));
		cliente.setEmail(req.getParameter("email"));
		cliente.setLogradouro(req.getParameter("logradouro"));
		cliente.setComplemento(req.getParameter("complemento"));
		cliente.setCep(req.getParameter("cep"));
		cliente.setUf(req.getParameter("uf"));
		cliente.setTp_cliente(req.getParameter("tp_cliente"));

		return cliente;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ClienteDAOBD clienteDAO = new ClienteDAOBD();
		try {
			ClienteVo cliente = clienteDAO.obterClientePorChave(Integer.valueOf(req.getParameter("id_cliente")));
			if (cliente != null) {
				cliente.setNome_cliente(req.getParameter("nome_cliente"));
				clienteDAO.alterarCliente(cliente);
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("sucessocliente.jsp");
			dispatcher.forward(req, resp);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected ClientePfVo createPFVo(HttpServletRequest req, Integer id_cliente) throws SQLException, ParseException {
		ClientePfVo clientePf = new ClientePfVo();
		ClienteDAOBD clienteDAO = new ClienteDAOBD();

		clientePf.setId_cliente(clienteDAO.obterMaxSeqCliente());
		clientePf.setCpf(req.getParameter("cpf"));
		clientePf.setCpf(req.getParameter("cpf"));

		String input = req.getParameter("dt_nascimento");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dt = sdf.parse(input);
		java.sql.Date dtSql = new java.sql.Date(dt.getTime());

		clientePf.setDt_nascimento(dtSql);

		return clientePf;
	}

	protected ClientePJVo createPJVo(HttpServletRequest req) throws SQLException {
		ClientePJVo clientePj = new ClientePJVo();
		ClienteDAOBD clienteDAO = new ClienteDAOBD();

		clientePj.setPj_id(1);
		clientePj.setCnpj(req.getParameter("cnpj"));
		clientePj.setId_cliente(clienteDAO.obterMaxSeqCliente());

		return clientePj;
	}

	protected void fillFormPj(ClientePJVo clientePJ, HttpServletRequest req) {
		req.setAttribute("cnpj", clientePJ.getCnpj());
	}

	protected void fillForm(ClienteVo cliente, HttpServletRequest req) {
		req.setAttribute("nome_cliente", cliente.getNome_cliente());
		req.setAttribute("email", cliente.getEmail());
		req.setAttribute("logradouro", cliente.getLogradouro());
		req.setAttribute("complemento", cliente.getComplemento());
		req.setAttribute("cep", cliente.getCep());
		req.setAttribute("uf", cliente.getUf());
		req.setAttribute("tp_cliente", cliente.getTp_cliente());
	}

}
