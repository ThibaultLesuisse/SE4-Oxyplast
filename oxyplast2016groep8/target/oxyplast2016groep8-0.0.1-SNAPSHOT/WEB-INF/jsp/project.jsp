<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Oxyplast</title>
    </head>
    
    <body>
        <h1>Details van project</h1>
        <b>Naam:</b>
        <c:out value="${project.naam}" /><br/>
        <b>Status:</b>
        <c:out value="${project.Status}" /><br/>
        <b>TeamId:</b>
        <c:out value="${project.TeamId}" /><br/>
        <br/>
        <c:url var="home" value="/home.html" />
        <a href='<c:out value="${home}"/>'>Home</a>
    </body>
</html>
