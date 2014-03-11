<%@page import="br.infnet.domain.Turma"%>
<%@page import="br.infnet.dao.TurmaDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestao de Turmas</title>
</head>
<body>
<h2>
Controle de Turmas
</h2>


<a href="index.jsp" >Controle de Aluno</a>
<hr />

<form  action="IncluirTurma" method="post"  >
Nome:  <input type="text" id="txtNome" name="txtNome" /> 
<input type="submit" value="Incluir" >
</form>

<ul>
<% TurmaDAO dao = new TurmaDAO();
for (Turma turma : dao.selecionar()  ){
%>


<li>
	<% out.print(turma.getNome()); %>

	<a href="ExcluirTurma?id=<%=turma.getId() %> ">Excluir</a> |
	<a href="GerenciarTurma?id=<%=turma.getId() %> ">Gerenciar</a>
	
</li>

<%} %>
</ul>

</body>
</html>