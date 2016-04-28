<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Feedback aanpassen</title>
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


        <c:url var="url" value="/editFeedback.html" />
        <form:form action="${url}" commandName="feedbackAanpassen" class="form-horizontal" method="POST">
            <%-- Spring form tags --%>
                <div class="form-group">
                    <label for="id" class="col-sm-2 control-label">ID</label>
                    <div class="col-sm-10">
                        <form:input type="number" class="form-control" id="id" path="id" placeholder="id" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="feedback" class="col-sm-2 control-label">Feedback</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="feedback" path="feedback" placeholder="De feedback" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="prototypeid" class="col-sm-2 control-label">Prototype ID</label>
                    <div class="col-sm-10">
                        <form:input type="prototypeid" class="form-control" id="prototypeid" path="prototypeid" placeholder="Prototype ID" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="partnerid" class="col-sm-2 control-label">Partner ID</label>
                    <div class="col-sm-10">
                        <form:input type="partnerid" class="form-control" id="partnerid" path="partnerid" placeholder="Partner ID" />
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" value="save" name="submit" class="btn btn-default">Submit</button>
                    </div>
                </div>

        </form:form>

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
        </div>
    </div>
</body>
</html>