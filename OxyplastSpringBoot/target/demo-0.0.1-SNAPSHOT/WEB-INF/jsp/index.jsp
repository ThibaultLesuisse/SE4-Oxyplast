<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    
    <body style="padding-top: 50px;">
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
            <li><a href="<c:url value="/" />">Home</a></li>
            <li><a href="<c:url value="/" />">Projecten</a></li>
            <li><a href="<c:url value="/" />">Profiel</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>
    
    
    <div class="container">
    <div class="table-responsive">
     <table class="table table-striped">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Status</th>
                  <th>naam</th>
                  <th>Team ID</th>
                </tr>
              </thead>
              <tbody>    
        <h1>Lijst van de projecten</h1>
        
            <c:forEach items="${project}" var="project">
                <c:url var="projectUrl" value="/project.html">
                    <c:param name="id" value="${project.id}" />
                </c:url>
                
                <tr>
                  <td> <a href='<c:out value="${projectUrl}"/>'><c:out value="${project.id}" /> </a></td>
                  <td>    <c:out value="${project.status}" /></td>
                  <td>   <c:out value="${project.naam}" /></td>
                  <td>   <c:out value="${project.teamId}" /></td>
                
                 <td>   
                <c:url var="editProject" value="/editProject.html">
                <c:param name="id" value="${project.id}" />
                </c:url>
        		<a href='<c:out value="${editProject}"/>'>Project Aanpassen</a>
                </td>
                
                <td>   
                <c:url var="deleteProject" value="/deleteProject.html">
                <c:param name="id" value="${project.id}" />
                </c:url>
        		<a href='<c:out value="${deleteProject}"/>'>Project Verwijderen</a>
                </td>
                </tr>
                
                
            </c:forEach>
        </tbody>
        </table>
        <c:url var="nieuwProjectUrl" value="/nieuwProject.html" />
        <a href='<c:out value="${nieuwProjectUrl}"/>'>Project Toevoegen</a>
        </div>
        </div>
    </body>
</html>
