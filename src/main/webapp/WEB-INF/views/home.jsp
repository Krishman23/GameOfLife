<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<html>
<head>
	<title>Game of Life</title>
</head>
<body>
${reenter}
<form:form method="POST"
          action="setdimension" modelAttribute="dimension">
          
             <table>
          		<thead>Select Dimensions 
          		</thead>
                <tr>
                    <td><form:label path="row">Row</form:label></td>
                    <td><form:input type="number" path="row" value="8"/></td>
                </tr>
                <tr>
                    <td><form:label path="col">Column</form:label></td>
                    <td><form:input type="number" path="col" value="6"/></td>
                </tr>
                
                <tr>
                    <td><br/><br/><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
</body>
</html>
