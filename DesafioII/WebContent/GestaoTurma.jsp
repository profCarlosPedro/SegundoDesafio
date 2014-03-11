<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gerir Turma</title>
</head>
<body>
<h2>
${turma.nome}
</h2>

<c:forEach var="aluno" items="${alunolist}">

${aluno.nome}

<c:if test="${aluno.turmas == null }">
	<a href="Associar?id=${turma.id}&matricula=${aluno.matricula}&tipo=0">associar</a>
</c:if>

<c:if test="${aluno.turmas != null }">
	<a href="Associar?id=${turma.id}&matricula=${aluno.matricula}&tipo=1">Desassociar</a>
</c:if>

<hr />
</c:forEach>


</body>
</html>