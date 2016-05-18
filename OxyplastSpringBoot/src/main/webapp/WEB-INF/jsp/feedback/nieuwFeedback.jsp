<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nieuwe Feedback</title>
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

        <h1>Nieuwe Feedback</h1>
        <c:url var="NieuwFeedbackUrl" value="/nieuwFeedback.html" />
        <form:form action="${NieuwFeedbackUrl}" commandName="defeedback" class="form-horizontal">
            <%-- Spring form tags --%>

                <div class="form-group">
                    <label for="feedback" class="col-sm-2 control-label">Feedback</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="feedback" path="feedback" placeholder="Feedback" />
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

    </div>
</body>
</html>