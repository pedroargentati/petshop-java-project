package br.com.fiap.cp5.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.cp5.dao.ProdutoDAOBD;
import br.com.fiap.cp5.model.ProdutoVo;

@WebServlet(urlPatterns = "/produto")
public class ProdutoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter out = resp.getWriter();
		ProdutoVo produto = new ProdutoVo();
		ProdutoDAOBD produtoDAO = new ProdutoDAOBD();
		
		produto.setNm_produto(req.getParameter("nome_produto"));
		produto.setVl_unitario(Double.valueOf(req.getParameter("vl_unitario")));

		try {
			
			
			Integer seq = produtoDAO.obterMaxSeqProduto();
			produto.setId_unidade(seq = seq + 1);
			produto.setId_status(seq = seq + 1);

			if (produto != null) {
				produtoDAO.inserirProduto(produto);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		out.println("<h1> Produto cadastrado com sucesso. </h1>");

	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProdutoDAOBD produtoDAO = new ProdutoDAOBD();
		
		List<ProdutoVo> listaProdutos = new ArrayList<ProdutoVo>();
		try {
			listaProdutos = produtoDAO.obterListaProduto();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.setAttribute("listaProdutos", listaProdutos);
		RequestDispatcher dispatcher = req.getRequestDispatcher("produto.jsp");
		dispatcher.forward(req, resp);
		
	}

}
