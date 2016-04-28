<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nieuwe Partner</title>
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

        <h1>Nieuwe Partner</h1>
        <c:url var="NieuwPartnerUrl" value="/nieuwPartner.html" />
        <form:form action="${NieuwPartnerUrl}" commandName="departner" class="form-horizontal">
            <%-- Spring form tags --%>

                <div class="form-group">
                    <label for="naam" class="col-sm-2 control-label">Naam</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="naam" path="naam" placeholder="naam" />
                    </div>
                </div>

                <div class="form-group">
                    <label for="voornaam" class="col-sm-2 control-label">Voornaam</label>
                    <div class="col-sm-10">
                        <form:input type="text" class="form-control" id="voornaam" path="voornaam" placeholder="voornaam" />
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