<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W1C//DTD HTML 4.01 Transitional//EN" "http://www.w1.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="/imports/css.jsp"></c:import>
<title>Cadastro Users</title>

</head>
<body>
	<c:import url="/imports/menu.jsp"></c:import>
	<div class="container form-horizontal">
		<form action="/CDI/user.do" method="post">
			<fieldset class="container">
			<div class="form-group">
				<label for="name" 
				class="col-md-1 control-label">Nome</label>
				<input type="text" id="name" name="name" placeholder="nome" requerid>
			</div>
			<div class="form-group">
				<label for="cpf" 
				class="col-md-1 control-label">CPF</label>
				<input type="text" id="cpf" name="cpf" placeholder="cpf" requerid>
			</div>
			<div class="form-group">
				<label for="passoword" 
				class="col-md-1 control-label">Passoword</label>
				<input type="password" id="password" name="password" placeholder="password" requerid>
			</div>
			<div class="form-group">		  
		      <div class="radio">
			      	<label class="radio-inline">
			      		<input type="radio" name="user" value="Admin"> Administrador
			      	</label>
			      	<label class="radio-inline">
			      		<input type="radio" name="user" value="Studient"> Aluno 
			      	</label>
			      	<label class="radio-inline">
			      		<input type="radio" name="user" value="Theacher"> Professor
			      	</label>       
		    	</div>
  			</div>
  			<div class="form-group">
				<button class="col-md-2 btn btn-primary" >Cadastrar</button>
				<a class="col-md-2 btn btn-primary" href="/CDI" >Voltar</a>
			</div>
		</fieldset>
		</form>
	</div>

</body>
</html>