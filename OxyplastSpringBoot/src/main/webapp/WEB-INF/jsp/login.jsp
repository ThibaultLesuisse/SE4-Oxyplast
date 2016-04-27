<%@page import="org.springframework.security.web.WebAttributes"%>
<%@page import="org.springframework.security.core.AuthenticationException"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
      
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Oxyplast</title>
        <c:url value="/resources/css/bootstrap.min.css" var="bootstrapcss" />
		<c:url value="/resources/css/bootstrap-theme.min.css" var="bootstraptheme" />
		<c:url value="/resources/js/bootstrap.min.js" var="bootstrapjs" />
		<c:url value="/resources/js/jquery-2.2.2.min.js" var="jq" />
		
		<script src="${jq}"></script>
		
		<link href="${bootstrapcss}" rel="stylesheet">
		<link href="${bootstraptheme}" rel="stylesheet">
		<script src="${bootstrapjs}"></script>
		
		
    </head>
    <body>
    <body style="padding-top: 50px;  background-image: url('/resources/images/bg.jpg');background-repeat:no-repeat;background-size:cover;">
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Oxplast</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          </ul>
         
        </div>
      </div>
    </nav>
    <div class="container">
        <div class="section">
                <c:if test="${not empty param.login_error}">
                        <div class="errors">
                                Er was een probleem om aan te loggen<br />Boodschap:
                                <%= ((AuthenticationException)
                                        session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)).getMessage() %>
                                <br /> <br /> 
                        </div>
                </c:if>
        </div>
</div>
    <div class="container" class="col-md-6" style="margin-top:10%;">
        <div class="section">
        <div class="panel panel-default">
  <div class="panel-heading">Inloggen</div>
  <div class="panel-body">
            <form name="f" action="<c:url value='/login' />" method="POST" class="form-horizontal">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <fieldset>
                <div class="form-group">
                    <div class="field">
                            <label for="username" class="col-sm-2 control-label">E-mailadres:</label>
                            <div class="output">
                             <div class="col-sm-10">
                                    <input type="text" name="username" id="username"  />
                                    </div>
                            </div>
                    </div>
                    </div>
                     <div class="form-group">
                    <div class="field">
                            <label for="password" class="col-sm-2 control-label">Paswoord:</label>
                            <div class="output">
                            <div class="col-sm-10">
                                    <input type="password" name="password" id="password" />
                                    </div>
                            </div>
                    </div>
                    </div>
                    <div class="form-buttons">
                        <div class="button">
                        <div class="col-sm-offset-2 col-sm-10">
                            <input name="submit" id="submit" type="submit" value="Login" class="btn btn-primary"/>
                            </div>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        </div>
        </div>
        </div>
    </body>
</html>
