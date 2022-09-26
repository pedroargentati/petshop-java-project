<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ taglib uri="http://struts.apache.org/tags-html-el" prefix="html-el" %> --%>
<%-- 	<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> --%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>CP5 | Cliente</title>
</head>
<body>

	<div class="main-title">

		<h1>CheckPoint 5 - Banco de dados - PAS</h1>
		<h2>Luciano</h2>

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

	<form id="form-contact" action="/CP5BDPAS/cliente" method="POST">
		<h2 class="contact-title">Cadastro de cliente</h2>

		<div class="center">

			<fieldset>

				<div class="name">
					<label for="nome_cliente">Nome completo: <span class="obg">*</span></label>
					<input type="text" name="nome_cliente" id="nome_cliente"
						placeholder="Ex: Pedro" required>
				</div>

				<div class="email">
					<label for="email">Email: <span class="obg">*</span></label> <input
						type="email" name="email" id="email"
						placeholder="exemplo@email.com" required>
				</div>

				<div class="logradouro">
					<label for="logradouro">Logradouro: <span class="obg">*</span></label>
					<input type="text" name="logradouro" id="logradouro"
						placeholder="Av Lins de Vasconcelos" maxlength="50" required>
				</div>

				<div class="complemento">
					<label for="complemento">Complemento: <span class="obg">*</span></label>
					<input type="text" name="complemento" id="complemento"
						placeholder="Apto 1" maxlength="15" required>
				</div>

				<div class="cep">
					<label for="cep">CEP: <span class="obg">*</span></label> <input
						type="number" name="cep" id="cep" placeholder="00000000"
						maxlength="8" required>
				</div>

				<div class="uf">
					<label for="uf">UF: <span class="obg">*</span></label> <input
						type="text" name="uf" id="uf" placeholder="SP" maxlength="2"
						required>
				</div>

				<fieldset>
					<legend>
						Tipo do cliente: <span class="obg">*</span>
					</legend>
					<% String tp_cliente = "PF"; %>
					<select name="tp_cliente" id="tp_cliente">
						<option value="" selected disabled hidden>Escolha uma
							opção</option>
						<option value="PF" <%= tp_cliente = "PF" %> >Pessoa Fisica (PF)</option>
						<option value="PJ" <%= tp_cliente = "PF" %> >Pessoa Jurídica (PJ)</option>
					</select>

					<% if(tp_cliente.equalsIgnoreCase("PJ")) {%>

					<div class="cnpj">
						<label for="cnpj">CNPJ: <span class="obg">*</span></label> <input type="number" name="cnpj" id="cnpj" placeholder="00000000" maxlength="14" required>
					</div>

				<% } else { %>

					<div class="cpf">
						<label for="cnpj">CPF: <span class="obg">*</span></label> 
						<input type="number" name="cpf" id="cpf" placeholder="000.000.000-00" maxlength="11" required>
					</div>

					<div class="dt_nascimento">
						<label for="dt_nascimento">Data Nascimento: <span class="obg">*</span></label> <input type="text" name="dt_nascimento" id="dt_nascimento" placeholder="00/00/00" required>
				</div>
				
				 <% } %>
					
				</fieldset>

				<hr>
				<p class="form-p"><span class="obg">*</span> campo obrigatório</p>

				<input type="checkbox" id="checkboxC" required> <label
					for="checkboxC" id="ciente">Ciente</label>
				<button name="submit" type="submit" id="contact-btn">Enviar</button>

			</fieldset>


		</div>

	</form>


	<form id="form-contact" action="/CP5BDPAS/cliente" method="GET">
		<h2 class="contact-title">Alteração do nome do Cliente</h2>

		<div class="center">

			<fieldset>

				<div class="id_cliente">
					<label for="id_cliente">Id cliente: <span class="obg">*</span></label>
					<input type="text" name="id_cliente" id="id_cliente" placeholder="Ex: 1" required>
				</div>

				<div class="name">
					<label for="nome_cliente">Nome completo: <span class="obg">*</span></label>
					<input type="text" name="nome_cliente" id="nome_cliente" placeholder="Ex: Pedro" required>
				</div>

				<hr>
				<p class="form-p">
					<span class="obg">*</span> campo obrigatório
				</p>

				<input type="checkbox" id="checkboxC" required> <label
					for="checkboxC" id="ciente">Ciente</label>
				<button name="submit" type="submit" id="contact-btn">Alterar</button>

			</fieldset>

		</div>

	</form>
	
	<form id="form-contact" action="/CP5BDPAS/clientedelete" method="POST">
		<h2 class="contact-title">Exclusão de cliente</h2>

		<div class="center">

			<fieldset>

				<div class="id_cliente">
					<label for="id_cliente">Id cliente: <span class="obg">*</span></label>
					<input type="text" name="id_cliente" id="id_cliente" placeholder="Ex: 1" required>
				</div>

				<fieldset>
					<legend>
						Tipo do cliente que deseja deletar: <span class="obg">*</span>
					</legend>
					<select name="tp_cliente" id="tp_cliente" required>
						<option value="" selected disabled hidden>Escolha uma opção</option>
						<option value="PF" >Pessoa Física (PF)</option>
						<option value="PJ" >Pessoa Jurídica (PJ)</option>
					</select>

				</fieldset>

				<hr>
				<p class="form-p">
					<span class="obg">*</span> campo obrigatorio
				</p>

				<input type="checkbox" id="checkboxC" required>
				<label for="checkboxC" id="ciente">Ciente</label>
				
				<button name="submit" type="submit" id="contact-btn">Excluir</button>

			</fieldset>


		</div>

	</form>
	

</body>
</html>