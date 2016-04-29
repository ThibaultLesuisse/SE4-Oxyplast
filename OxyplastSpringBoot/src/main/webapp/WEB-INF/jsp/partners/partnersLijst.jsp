<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lijst van partner</title>
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
                        <th>Naam</th>
                        <th>Voornaam</th>
                    </tr>
                </thead>
                <tbody>
                    <h1>Lijst van de Partners</h1>

                    <c:forEach items="${partnerItems}" var="partner">
                        <c:url var="partnerUrl" value="partner.html">
                            <c:param name="id" value="${partner.id}" />
                        </c:url>

                        <tr>
                            <td>
                                <a href='<c:out value="${partnerUrl}"/>'>
                                    <c:out value="${partner.id}" /> </a>
                            </td>
                            <td>
                                <c:out value="${partner.naam}" />
                            </td>
                            <td>
                                <c:out value="${partner.voornaam}" />
                            </td>

                            <td>
                                <c:url var="editPartner" value="editPartner.html">
                                    <c:param name="id" value="${partner.id}" />
                                </c:url>
                                <a href='<c:out value="${editPartner}"/>'>Partner Aanpassen</a>
                            </td>

                            <td>
                                <c:url var="deletePartner" value="/partners/deletePartner.html">
                                    <c:param name="id" value="${partner.id}" />
                                </c:url>
                                <a href='<c:out value="${deletePartner}"/>'>Partner Verwijderen</a>
                            </td>
                        </tr>


                    </c:forEach>
                </tbody>
            </table>
            <c:url var="nieuwPartnerUrl" value="/partners/nieuwPartner.html" />
            <a href='<c:out value="${nieuwPartnerUrl}"/>'>Partner Toevoegen</a>
        </div>
    </div>
</body>

</html>