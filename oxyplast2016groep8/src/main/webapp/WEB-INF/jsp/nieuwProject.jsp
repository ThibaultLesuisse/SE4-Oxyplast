<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Oxyplast</title>
    </head>
    
    <body>
        <h1>Project toevoegen</h1>
        <c:url var="url" value="/nieuwProject.html" />
        <form:form action="${url}" commandName="hetproject">   <%-- Spring form tags --%>
            <fieldset>
                <div><label>Naam:</label><form:input path="naam"/></div>
                <div><label>Status:</label><form:input path="Status"/></div>
                <div><label>TeamId:</label><form:input path="TeamId"/></div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
    </body>
</html>