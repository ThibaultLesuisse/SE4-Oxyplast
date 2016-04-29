<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Overzicht Feedback</title>
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
        <h1>Details van feedback</h1>
        <div class="table-responsive">
            <table class="table table-striped">
                <tbody>
                    <tr>
                        <td>ID</td>
                        <td>
                            <c:out value="${feedback.id}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Feedback</td>
                        <td>
                            <c:out value="${feedback.feedback}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Prototype ID</td>
                        <td>
                            <c:out value="${feedback.prototypeid}" />
                        </td>
                    </tr>
                    <tr>
                        <td>Partner ID</td>
                        <td>
                            <c:out value="${feedback.partnerid}" />
                        </td>
                    </tr>
                </tbody>
            </table>
            
            <c:url var="homeFeedback" value="feedbackLijst.html" />
            <a href='<c:out value="${homeFeedback}"/>'>Terug</a>
        </div>
    </div>
</body>

</html>