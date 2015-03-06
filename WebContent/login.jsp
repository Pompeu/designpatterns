<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="/imports/css.jsp"></c:import>
<title>Insert title here</title>
</head>
<body>
	<c:import url="/imports/menu.jsp"></c:import>
	<div class="container form-horizontal">
		<form action="/CDI/login.do" method="post">
			<fieldset class="container">
				<div class="form-group">
					<label for="name" 
					class="col-md-1 control-label">Nome</label>
					<input type="text" name="name" placeholder="nome">
				</div>
				<div class="form-group">
					<label for="password" 
					class="col-md-1 control-label">Senha</label>
					<input type="password"  name="password"  placeholder="password">
				</div>
				<div class="form-group">
					<button class="col-md-2 btn btn-primary" >Logar</button>
					<a class="col-md-2 btn btn-primary" href="/CDI" >Voltar</a>
				</div>
			</fieldset>
		</form>
	</div>
	
</body>
</html>