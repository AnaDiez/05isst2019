<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
<head>
<title>Formulario</title>
</head>
 
<body>
    <h2>Los campos que ha seleccionado se muestran a continuaci�n:</h2>
    <br>
    <!--<c:forEach var="campo" items="${formulario.campo}">  
            <c:out value="${campo}"/><br>
    </c:forEach>
    -->
        Ha seleccionado los siguientes campos:
        
	<c:forEach items="${camposseleccionados}" var="current">

		<tr><c:out value="${current}" /></tr>

	</c:forEach>
	
	
 
</body>
</html>