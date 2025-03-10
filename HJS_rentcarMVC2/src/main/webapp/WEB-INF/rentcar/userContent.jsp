<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<c:if test="${vo == null}">
	<div class="detail-container">
		<h1 class="no-match">일치하는 회원이 없습니다</h1>
	</div>
</c:if>
<c:if test="${vo ne null}">
	<div class="detail-container">
		<h1>${vo.name}회원의 상세보기</h1>
		<form action="${ctx}/userUpdate.do" method="post" id="updateForm"
			onsubmit="return validateForm(event)">
			<input type="hidden" name="num" id="num" value="${vo.num}" />
			<!-- Spring Security CSRF 토큰 추가 (필요 시) -->
			<security:csrfInput />
			<div class="detail-wrapper">
				<table class="detail-table">
					<tr>
						<td>번호</td>
						<td class="left">${vo.num}</td>
					</tr>
					<tr>
						<td>아이디</td>
						<td class="left">${vo.userId}</td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td class="left">${vo.pwd}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td class="left">${vo.name}</td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email" value="${vo.email}"
							class="input-field" required /></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phone" value="${vo.phone}"
							class="input-field" required /></td>
					</tr>
				</table>
				<div class="btn-group">
					<button type="submit" class="btn-submit">수정</button>
					<button type="button" class="btn-cancel"
						onclick="window.history.back()">취소</button>
				</div>
			</div>
		</form>
	</div>
</c:if>

<script src="${ctx}/js/content.js"></script>
<%@ include file="/part/footer.jsp"%>