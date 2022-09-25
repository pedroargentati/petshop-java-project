<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<header>

		<nav>
			<ul class="header-nav">
				<li><a href="cliente.jsp">Cliente</a></li>
				<li><a href="produtos.html">Produtos</a></li>
				<li><a href="venda.html">Vendas</a></li>
			</ul>
		</nav>

	</header>

	<h1 style="margin 0 auto;">
		Cliente:
		<%=request.getAttribute("nome_cliente")%>
		cadastrado com sucesso.
	</h1>

</body>
</html>