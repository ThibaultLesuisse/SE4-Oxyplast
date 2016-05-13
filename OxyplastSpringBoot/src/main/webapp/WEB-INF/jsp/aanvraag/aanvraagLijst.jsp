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

    <script src="${jq}"></script>

    <link href="${bootstrapcss}" rel="stylesheet">
    <link href="${bootstraptheme}" rel="stylesheet">
    <script src="${bootstrapjs}"></script>
</head>

<body style="padding-top: 50px;">
   
    <div class="container">
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Klant ID</th>
                        <th>Aanvraag</th>
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
                                    <c:out value="${aanvraag.klantid}" /> </a>
                            </td>
                            <td>
                                <c:out value="${aanvraag.aanvraag}" />
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