<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="/imports/css.jsp"></c:import>
<title>Index Main</title>
</head>
<body>
	<c:import url="/imports/menu.jsp"></c:import>
	<c:if test="${not empty user}">
		<div>O User ${user.nome} foi cadastrado com sucesso como
			${user.nivel}</div>
	</c:if>
	<c:if test="${not empty result}">
		<div>${result}</div>
	</c:if>
</body>
</html>