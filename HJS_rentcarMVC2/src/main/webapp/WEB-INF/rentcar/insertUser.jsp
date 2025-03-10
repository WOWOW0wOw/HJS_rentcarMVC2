<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<div class="container">
	<h1>회원가입</h1>
	<form action="${ctx}/userAdd.do" method="post">
		<table class="signup-table">
			<tr>
				<td>아이디</td>
				<td class="input-group"><input type="text" name="userid"
					id="userid" class="input-field" autofocus required /> <input
					type="button" value="중복체크" id="checkId" class="btn-check" /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input type="password" name="pwd" id="pwd"
					class="input-field" required /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" id="name"
					class="input-field" required /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" id="email"
					class="input-field" required /></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" name="phone" id="phone"
					class="input-field" required /></td>
			</tr>
			<tr>
				<td></td>
				<td class="btn-group">
					<button class="btn-submit" onclick="validCheck(form)">가입</button>
					<button type="reset" class="btn-cancel">취소</button>
				</td>
			</tr>
		</table>
	</form>
</div>

<script src="${ctx}/js/insert.js">
	
</script>
<%@ include file="/part/footer.jsp"%>