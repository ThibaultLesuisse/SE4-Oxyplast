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
           <li>
           <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Projecten <span class="caret"></span></a>
           <ul class="dropdown-menu">
            <li><a href="<c:url value="/" />">Overzicht Projecten</a></li>
            <li><a href="<c:url value="/aanvraagOverzicht" />">Overzicht Aanvragen</a></li>
            <li><a href="<c:url value="/prototypeOverzicht" />"">Overzicht Prototypes</a></li>
            <li><a href="<c:url value="/leverancierOverzicht" />"">Overzicht Leveranciers</a></li>
            <li><a href="<c:url value="/teamoverzicht" />"">Overzicht Teams</a></li>
          </ul>    
           </li>
            <li><a href="<c:url value="/profiel" />">Profiel</a></li>
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
                  <th>ProjectID</th>
                  <th>Omschrijving</th>
                </tr>
              </thead>
              <tbody>    
        <h1>Lijst van de projecten</h1>
        
            <c:forEach items="${team}" var="team">
                <c:url var="teamUrl" value="teams/team.html">
                    <c:param name="id" value="${team.teamid}" />
                </c:url>
                
                <tr>
                  <td> <a href='<c:out value="${teamUrl}"/>'><c:out value="${team.teamid}" /> </a></td>
                  <td>    <c:out value="${team.projectid}" /></td>
                  <td>   <c:out value="${team.omschrijving}" /></td>
                
                 <td>   
                <c:url var="editTeam" value="team/editTeam.html">
                <c:param name="id" value="${team.id}" />
                </c:url>
        		<a href='<c:out value="${editTeam}"/>'>Team Aanpassen</a>
                </td>
                
                <td>   
                <c:url var="deleteTeam" value="team/deleteTeam.html">
                <c:param name="id" value="${team.teamid}" />
                </c:url>
        		<a href='<c:out value="${deleteTeam}"/>'>Team verwijderen</a>
                </td>
                </tr>
                
                
            </c:forEach>
        </tbody>
        </table>
        <c:url var="nieuwTeamUrl" value="/team/nieuwTeam.html" />
        <a href='<c:out value="${nieuwTeamUrl}"/>'>Team Toevoegen</a>
        </div>
        </div>
    </body>
</html>
