<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>point</title>
</head>
<body>
	<h1>
		<c:out value="${point}" />
		付与!
	</h1>
	<br />
	<h2>
		現在の保持ポイント:
		<c:out value="${afterPoint}" />
	</h2>
	<br />
	<br />

	<h2>履歴</h2>
	<hr />
	<table border="1">
		<tr>
			<th>日付</th>
			<th>ポイント</th>
		</tr>

		<c:forEach var="history" items="${pointHistoryList}">
			<tr>
				<td><fmt:formatDate value="${history.created_at}" pattern="yyyy年MM月dd日 HH:mm" /></td>
				<td>${history.point}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>