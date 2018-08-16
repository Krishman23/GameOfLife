
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="count" scope="session" value="${0}" />
Current Dimension:[ ${dimension.row} x ${dimension.col} ]
<br/>
Please Click in the box to make it alive. 
<br/><br/>
<form:form method="POST" action="startGameofLife" name="startGameofLife"
	modelAttribute="dimension">
	<div class="form">
		<form:hidden path="row" />
		<form:hidden path="col" />

		<c:forEach varStatus="ref" var="singleDisp"
			items="${dimension.arrayDisplay}">


			<form:hidden path="arrayDisplay[${count}]" />
			<div class="common dead">
				<span id="${count}"> <c:out value='${singleDisp}' />
			</div>
			</span>

			<c:choose>
				<c:when test="${(count+1)%(dimension.col)=='0'}">
					<div></div>
				</c:when>

			</c:choose>
			<c:set var="count" value="${count +1}" />

		</c:forEach>
		
			<form:label path="itr">Iterate &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:</form:label>
			<form:input type="number" path="itr"  value="1"/><br/>
			<form:label path="itrSpeed">Speed(ms)&nbsp;:</form:label>
			<form:input type="number" path="itrSpeed" value="500"/><br/>
			 
			
		<br />
		<br /><div class="submit">
			 <input id="submit" type="submit" value="Submit" /></div>
			 </div>
			 <br/>
 <input id="stop" type="button" value="Stop"/>
</form:form>

