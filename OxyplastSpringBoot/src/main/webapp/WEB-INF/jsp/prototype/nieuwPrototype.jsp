<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nieuw Prototype</title>
    <c:url value="/resources/css/bootstrap.min.css" var="bootstrapcss" />
    <c:url value="/resources/css/bootstrap-theme.min.css" var="bootstraptheme" />
    <c:url value="/resources/js/bootstrap.min.js" var="bootstrapjs" />
    <c:url value="/resources/js/jquery-2.2.2.min.js" var="jq" />
  <link href='https://fonts.googleapis.com/css?family=Lato' rel='stylesheet' type='text/css'>
    <script src="${jq}"></script>

    <link href="${bootstrapcss}" rel="stylesheet">
    <link href="${bootstraptheme}" rel="stylesheet">
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
            <li><a href="<c:url value="/project/projectenLijst.html" />">Overzicht Projecten</a></li>
            <li><a href="<c:url value="/aanvraag/aanvraagLijst.html" />">Overzicht Aanvragen</a></li>
            <li><a href="<c:url value="/prototype/prototypeLijst.html" />">Overzicht Prototypes</a></li>
            <li><a href="<c:url value="leverancier/leverancierOverzicht.html" />">Overzicht Leveranciers</a></li>
            <li><a href="<c:url value="/team/teamoverzicht" />">Overzicht Teams</a></li>
            <li><a href="<c:url value="/feedback/feedbackLijst" />">Overzicht Feedback</a></li>
            <li><a href="<c:url value="/partners/partnersLijst" />">Overzicht Partners</a></li>
          </ul>    

           </li>
            <li><a href="<c:url value="/profiel" />"><i class="fa fa-user" aria-hidden="true"></i></a></li>
            <li><a href="#"><i class="fa fa-comments" aria-hidden="true"></i></a></li>
          </ul>
        </div>
      </div>
    </nav>
    
    <div class="container">

        <h1>Nieuw Prototype</h1>
        <c:url var="NieuwPrototypeUrl" value="/prototype/nieuwPrototype.html" />
        <form:form action="${NieuwPrototypeUrl}" commandName="hetprototype" class="form-horizontal">
            <%-- Spring form tags --%>

                <div class="form-group">
                    <label for="project" class="col-sm-2 control-label">project</label>
                    <div class="col-sm-10">
                       <select name="project">
							    <c:forEach var="project" items="${projectDropdown}">
							        <option id="project" path="project" value="${project}">${project.naam}</option>
							    </c:forEach>
							</select>
                    </div>
                </div>

                <div class="form-group">
                    <label for="formule" class="col-sm-2 control-label">Formule</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="formule" path="formule" placeholder="formule" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" value="save" name="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>
        </form:form>

    </div>
</body>
</html>