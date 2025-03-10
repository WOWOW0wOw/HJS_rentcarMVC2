<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<script type="text/javascript">
	function deleteFn(id, num) {
		location.href = "${ctx}/userDelete.do?num=" + num + "&id=" + id;
	}
</script>
<div class="ulist">
	<h1>회원 목록</h1>
	<table class="user-table">
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="vo" items="${list}">
				<tr>
					<td>${vo.num}</td>
					<td><a href="${ctx}/userContent.do?num=${vo.num}"
						class="user-link">${vo.userId}</a></td>
					<td>${vo.pwd}</td>
					<td>${vo.name}</td>
					<td>${vo.email}</td>
					<td>${vo.phone}</td>
					<td><input type="button" value="삭제" class="btn-del"
						onclick="deleteFn('${vo.userId}','${vo.num}')"
						<c:if test="${loginId!=vo.userId and loginId!='admin'}"> 
                disabled="disabled"
              </c:if> />
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="/part/footer.jsp"%>