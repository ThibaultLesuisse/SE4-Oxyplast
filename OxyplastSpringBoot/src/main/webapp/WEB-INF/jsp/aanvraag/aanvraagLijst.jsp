<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lijst van Aanvragen</title>
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
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Naam klant</th>
                        <th>Aanvraag</th>
						<th>Aanvraag Aanvaard</th>
                    </tr>
                </thead>
                <tbody>
                    <h1>Lijst van de aanvragen</h1>

                    <c:forEach items="${aanvraagItems}" var="aanvraag">
                        <c:url var="aanvraagUrl" value="/aanvraag/aanvraag.html">
                            <c:param name="id" value="${aanvraag.id}" />
                        </c:url>

                        <tr>
                            <td>
                                <a href='<c:out value="${aanvraagUrl}"/>'>
                                    <c:out value="${aanvraag.klant.naam}" /> </a>
                            </td>
                            <td>
                                <c:out value="${aanvraag.aanvraag}" />
                            </td>
                            <td>
                                <c:out value="${aanvraag.aanvraagaanvaard}" />
                            </td>
  							<td>
                                <c:url var="aanvaardAanvraag" value="/aanvraag/aanvaardAanvraag.html">
                                    <c:param name="id" value="${aanvraag.id}" />
                                </c:url>
                                <a href='<c:out value="${aanvaardAanvraag}"/>'>Aanvraag Aanvaarden</a>
                            </td>

                            <td>
                                <c:url var="editAanvraag" value="editAanvraag.html">
                                    <c:param name="id" value="${aanvraag.id}" />
                                </c:url>
                                <a href='<c:out value="${editAanvraag}"/>'>Aanvraag Aanpassen</a>
                            </td>

                            <td>
                                <c:url var="deleteAanvraag" value="/aanvraag/deleteAanvraag.html">
                                    <c:param name="id" value="${aanvraag.id}" />
                                </c:url>
                                <a href='<c:out value="${deleteAanvraag}"/>'>Aanvraag Verwijderen</a>
                            </td>
                        </tr>


                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>