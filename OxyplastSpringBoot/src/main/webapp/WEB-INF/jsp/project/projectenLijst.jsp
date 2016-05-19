<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    
    <script src="${bootstrapjs}"></script>
</head>
<body style="font-family:Lato;">
    <nav class="navbar navbar-default navbar-static-top">
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
            <li><a href="<c:url value="/prototypeOverzicht" />">Overzicht Prototypes</a></li>
            <li><a href="<c:url value="/leverancierOverzicht" />">Overzicht Leveranciers</a></li>
            <li><a href="<c:url value="/teamoverzicht" />">Overzicht Teams</a></li>
          </ul>    
           </li>
            <li><a href="<c:url value="/profiel" />">Profiel</a></li>
            <li><a href="#">Help</a></li>
          </ul>
        </div>
      </div>
    </nav>
    <div class="col-sm-12 col-md-12 col-lg-12">
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
                        <c:url var="projectUrl" value="/project/project.html">
                            <c:param name="id" value="${project.id}" />
                        </c:url>
                        <tr>
                            <td>
                                <a href='<c:out value="${projectUrl}"/>'>
                                    <c:out value="${project.id}" /> </a>
                            </td>
                            <td>
                                <c:out value="${project.status}" />
                            </td>
                            <td>
                                <c:out value="${project.naam}" />
                            </td>
                            <td>
                                <c:out value="${project.teamId}" />
                            </td>

                            <td>
                                <c:url var="editProject" value="/project/editProject.html">
                                    <c:param name="id" value="${project.id}" />
                                </c:url>
                                <a href='<c:out value="${editProject}"/>'>Project Aanpassen</a>
                            </td>

                            <td>
                                <c:url var="deleteProject" value="/project/deleteProject.html">
                                    <c:param name="id" value="${project.id}" />
                                </c:url>
                                <a href='<c:out value="${deleteProject}"/>'>Project Verwijderen</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <c:url var="nieuwProjectUrl" value="/project/nieuwProject.html" />
            <a href='<c:out value="${nieuwProjectUrl}"/>'>Project Toevoegen</a>
        </div>
    </div>
    </div>
</body>
</html>