<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lijst van Prototypes</title>
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
                        <th>Project Naam</th>
                        <th>Formule</th>
                    </tr>
                </thead>
                <tbody>
                    <h1>Lijst van de Prototypes</h1>

                    <c:forEach items="${prototypeItems}" var="prototype">
                        <c:url var="PrototypeUrl" value="/prototype/prototype.html">
                            <c:param name="id" value="${prototype.id}" />
                        </c:url>

                        <tr>
                            <td>
                                <a href='<c:out value="${prototypeUrl}"/>'>
                                    <c:out value="${prototyper.id}" /> </a>
                            </td>
                            <td>
                                <c:out value="${prototype.project.naam}" />
                            </td>
                            <td>
                                <c:url var="editPrototype" value="prototype/editPrototype.html">
                                    <c:param name="id" value="${prototype.id}" />
                                </c:url>
                                <a href='<c:out value="${editPrototype}"/>'>Prototype Aanpassen</a>
                            </td>

                            <td>
                                <c:url var="deletePrototype" value="/prototype/deletePrototype.html">
                                    <c:param name="id" value="${prototype.id}" />
                                </c:url>
                                <a href='<c:out value="${deletePrototype}"/>'>Prototype Verwijderen</a>
                            </td>
                        </tr>


                    </c:forEach>
                </tbody>
            </table>
            <c:url var="nieuwPrototypeUrl" value="/prototype/nieuwPrototype.html" />
            <a href='<c:out value="${nieuwPrototypeUrl}"/>'>Prototype Toevoegen</a>
        </div>
    </div>
</body>

</html>