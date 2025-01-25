<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>list todos page</title>
</head>
<body>
	welcome to ${name} !!!
	<div>Your Todos are:</div>
	<table>

		<thead>
			<tr>
				<th>id</th>
				<th>Description</th>
				<th>Target-date</th>
				<th>Is He Completed</th>
			<tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
				<tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>