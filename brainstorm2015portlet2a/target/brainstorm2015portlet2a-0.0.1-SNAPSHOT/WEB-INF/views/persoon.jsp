<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Details van persoon</h1>
        <b>Id:</b>
        <c:out value="${persoon.id}" /><br/>
        <b>Voornaam:</b>
        <c:out value="${persoon.voornaam}" /><br/>
        <b>Familienaam:</b>
        <c:out value="${persoon.familienaam}" /><br/>
        <b>E-mailadres:</b>
        <c:out value="${persoon.emailadres}" /><br/>
        <b>Paswoord:</b>
        <c:out value="${persoon.paswoord}" /><br/>
        <br/>

        <portlet:renderURL var="showUrl">
			<portlet:param name="myaction" value="" />
 		</portlet:renderURL>
        <a href='<c:out value="${showUrl}"/>'>Home</a>
    </body>
</html>
