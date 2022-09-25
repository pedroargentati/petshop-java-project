<%@page import="br.com.fiap.cp5.dao.ProdutoDAOBD"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fiap.cp5.model.ProdutoVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>CP5 | Produto</title>
</head>
<body>

	<div class="main-title">

		<h1>CheckPoint 5 - Banco de dados - PAS</h1>
		<h2>Luciano Rubinho</h2>

	</div>

	<header>

		<nav>
			<ul class="header-nav">
				<li><a href="cliente.jsp">Cliente</a></li>
				<li><a href="produto.jsp">Produtos</a></li>
				<li><a href="venda.html">Vendas</a></li>
			</ul>
		</nav>

	</header>

	<form id="form-contact" action="/CP5BDPAS/produto" method="POST">
		<h2 class="contact-title">Cadastro de Produto</h2>

		<div class="center">
			<fieldset>
			
				<div class="name">
					<label for="nome_produto">Nome do Produto: <span
						class="obg">*</span></label> <input type="text" name="nome_produto"
						id="nome_produto" placeholder="Ex: Caneta" required>
				</div>

				<div class="vl_unitario">
					<label for="vl_unitario">Valor Unitário: <span class="obg">*</span></label>
					<input type="number" name="vl_unitario" id="vl_unitario"
						placeholder="R$ 0,0" pattern="[0-9]+([,\.][0-9]+)?" min="0"
						step="any" required>
				</div>

				<hr>
				<p class="form-p">
					<span class="obg">*</span> campo obrigatório
				</p>

				<button name="submit" type="submit" id="contact-btn">Enviar</button>

			</fieldset>
		</div>
	</form>


	<form id="form-contact" action="/CP5BDPAS/produto" method="GET">
		<h2 class="contact-title">Lista de produtos</h2>

		<div class="center">
			<fieldset>

				<h3>Produtos:</h3>
				<%
				List<ProdutoVo> produtos = new ProdutoDAOBD().obterListaProduto();
				for (ProdutoVo produto : produtos) {
				%>
				
				<tr>
					<td> <%=produto.getNm_produto()%></td>
					<br>
				</tr>
				
				<%
				}
				%>
				<hr>
				
				<button name="submit" type="submit" id="contact-btn">Listar</button>
				

			</fieldset>
		</div>
	</form>

</body>
</html>