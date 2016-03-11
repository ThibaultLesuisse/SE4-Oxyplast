<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom bij Oxyplast</title>
    </head>
    
    <body>
        <h1>Lijst van de projecten</h1>
        <ul>
            <c:forEach items="${project}" var="project">
                <c:url var="projectUrl" value="/project.html">
                    <c:param name="id" value="${project.id}" />
                </c:url>
                <li>
                    <a href='<c:out value="${projectUrl}"/>'>
                        <c:out value="${project.teamId}" />
                        <c:out value="${project.status}" />
                        <c:out value="${project.naam}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        <c:url var="nieuwProjectUrl" value="/nieuwProject.html" />
        <a href='<c:out value="${nieuwProjectUrl}"/>'>Project Toevoegen</a>
    </body>
</html>
