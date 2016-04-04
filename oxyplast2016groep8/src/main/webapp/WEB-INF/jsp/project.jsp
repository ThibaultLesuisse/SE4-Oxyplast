<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Oxyplast</title>
    </head>
    
    <body>
        <h1>Details van project</h1>
        <b>ID:</b>
        <c:out value="${project.id}" /><br/>
        <b>Naam:</b>
        <c:out value="${project.naam}" /><br/>
        <b>Status:</b>
        <c:out value="${project.status}" /><br/>
        <b>TeamId:</b>
        <c:out value="${project.teamId}" /><br/>
        <br/>
        <c:url var="home" value="/home.html" />
        <a href='<c:out value="${home}"/>'>Home</a>
        
        <a href="<c:url value='/delete-project'><c:param name="id" value="${project.id}" /></c:url>">Delete project</a>
        
        
        
    </body>
</html>
