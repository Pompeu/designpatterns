<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-default navbar-static-top">
  		<div class="container-fluid">
		    <div class="navbar-header">
		      <a class="navbar-brand" href="<c:url value='ctrl.do?ctrl=UserForm'/>">
		        <img alt="Cadastro" src="">
		      </a>
		      <a class="navbar-brand" href='<c:url value='ctrl.do?ctrl=LoginForm'/>'>
		        <img alt="Logar" src="">
		      </a>
		         <a class="navbar-brand" href='<c:url value='ctrl.do?ctrl=LogoutService'/>'>
		        <img alt="Sair" src="">
		      </a>
		    </div>
	  	</div>
</nav>