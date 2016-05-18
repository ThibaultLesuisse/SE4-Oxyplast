<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lijst van feedback</title>
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
                        <th>Feedback</th>
                        <th>Prototype ID</th>
                        <th>Partner ID</th>
                    </tr>
                </thead>
                <tbody>
                    <h1>Lijst van de Feedback</h1>

                    <c:forEach items="${feedbackItems}" var="feedback">
                        <c:url var="feedbackUrl" value="feedback.html">
                            <c:param name="id" value="${feedback.id}" />
                        </c:url>

                        <tr>
                            <td>
                                <a href='<c:out value="${feedbackUrl}"/>'>
                                    <c:out value="${feedback.id}" /> </a>
                            </td>
                            <td>
                                <c:out value="${feedback.feedback}" />
                            </td>
                            <td>
                                <c:out value="${feedback.prototypeid}" />
                            </td>
                            <td>
                                <c:out value="${feedback.partnerid}" />
                            </td>

                            <td>
                                <c:url var="editFeedback" value="editFeedback.html">
                                    <c:param name="id" value="${feedback.id}" />
                                </c:url>
                                <a href='<c:out value="${editFeedback}"/>'>Feedback Aanpassen</a>
                            </td>

                            <td>
                                <c:url var="deleteFeedback" value="/feedback/deleteFeedback.html">
                                    <c:param name="id" value="${feedback.id}" />
                                </c:url>
                                <a href='<c:out value="${deleteFeedback}"/>'>Feedback Verwijderen</a>
                            </td>
                        </tr>


                    </c:forEach>
                </tbody>
            </table>
            <c:url var="nieuwFeedbackUrl" value="/feedback/nieuwFeedback.html" />
            <a href='<c:out value="${nieuwFeedbackUrl}"/>'>Feedback Toevoegen</a>
        </div>
    </div>
</body>

</html>