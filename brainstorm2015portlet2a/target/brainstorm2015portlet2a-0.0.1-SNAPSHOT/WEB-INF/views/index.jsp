<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Overzicht van personen</h1>
        
        <ul>
            <c:forEach items="${personen}" var="persoon">
            
				<portlet:renderURL var="persoonUrl">
					<portlet:param name="myaction" value="persoonDetail" />
					<portlet:param name="id" value="${persoon.id}" />
				</portlet:renderURL>					

                <li>
                    <a href='<c:out value="${persoonUrl}"/>'>
                        <c:out value="${persoon.voornaam}" />
                        <c:out value="${persoon.familienaam}" />
                    </a>
                </li>
            </c:forEach>
        </ul>
        
		<portlet:renderURL var="showAddPersoonUrl">
			<portlet:param name="myaction" value="addPersoonForm" />
		</portlet:renderURL>
		
		<a href='<c:out value="${showAddPersoonUrl}"/>'> Nieuwe persoon toevoegen</a>
		
		
    </body>
</html>
