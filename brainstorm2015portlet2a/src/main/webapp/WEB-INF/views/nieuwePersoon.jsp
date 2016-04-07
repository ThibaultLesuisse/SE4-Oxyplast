<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Brainstormapplicatie</title>
    </head>
    
    <body>
        <h1>Persoon toevoegen</h1>

		<portlet:actionURL var="addPersoonActionUrl">
			<portlet:param name="myaction" value="addPersoon" />
		</portlet:actionURL>

        <form:form action="${addPersoonActionUrl}" commandName="persoon" method="post">   <%-- Spring form tags --%>
            <fieldset>
                <div><label>Voornaam:</label><form:input path="voornaam"/></div>
                <div><label>Familienaam:</label><form:input path="familienaam"/></div>
                <div><label>E-mailadres:</label><form:input path="emailadres"/></div>
                <div><label>Paswoord:</label><form:input path="paswoord"/></div>
                <div><input name="submit" type="submit" value="save"/></div>
            </fieldset>
        </form:form>
    </body>
</html>
