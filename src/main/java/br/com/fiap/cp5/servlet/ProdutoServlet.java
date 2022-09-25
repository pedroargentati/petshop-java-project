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
			produto.setId_unidade(++seq);
			produto.setId_status(++seq);

			if (produto != null) {
				produtoDAO.inserirProduto(produto); 
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("produto.jsp");
		dispatcher.forward(req, resp);

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
		this.fillForm(listaProdutos, req);
		RequestDispatcher dispatcher = req.getRequestDispatcher("produto.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	protected void fillForm(List<ProdutoVo> listaProdutos,  HttpServletRequest req) {
		req.setAttribute("listaProdutos", listaProdutos);
	}

}
