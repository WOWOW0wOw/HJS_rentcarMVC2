<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<div class="rentcarUpdate-container">
	<h2 class="update-title">차량 정보 수정</h2>
	<form action="${ctx}/rentcarUpdateSet.do" method="post"
		enctype="multipart/form-data" class="update-form">
		<div class="update-table-wrapper">
			<table class="update-table">
				<tr>
					<th>차량 이름</th>
					<td><input type="text" name="name" value="${vo.name}"
						class="input-field" required></td>
				</tr>
				<tr>
					<th>카테고리</th>
					<td><select name="category" class="select-field" required>
							<option value="1" ${vo.category == 1 ? 'selected' : ''}>소형</option>
							<option value="2" ${vo.category == 2 ? 'selected' : ''}>중형</option>
							<option value="3" ${vo.category == 3 ? 'selected' : ''}>대형</option>
					</select></td>
				</tr>
				<tr>
					<th>가격 (일 단위)</th>
					<td><input type="number" name="price" value="${vo.price}"
						class="input-field" min="0" required></td>
				</tr>
				<tr>
					<th>승차 인원</th>
					<td><input type="number" name="usepeople"
						value="${vo.usepeople}" class="input-field" min="1" required></td>
				</tr>
				<tr>
					<th>총 수량</th>
					<td><input type="number" name="totalQty"
						value="${vo.totalQty}" class="input-field" min="0" required></td>
				</tr>
				<tr>
					<th>회사</th>
					<td><input type="text" name="company" value="${vo.company}"
						class="input-field" required></td>
				</tr>
				<tr>
					<th>차량 이미지</th>
					<td>
						<div class="image-preview">
							<img src="${ctx}/img/${vo.img}" alt="Current Image"
								class="preview-image">
						</div> <input type="file" name="img" accept="image/*" class="file-input">
						<input type="hidden" name="currentImg" value="${vo.img}">
					</td>
				</tr>
				<tr>
					<th>차량 정보</th>
					<td><textarea name="info" class="textarea-field" required>${vo.info}</textarea></td>
				</tr>
			</table>
			<div class="btn-group">
				<input type="hidden" name="num" id="num" value="${vo.num}">
				<button type="submit" class="submit-btn">수정 완료</button>
				<button type="button" class="delete-btn"
					onclick="location.href='${ctx}/rentcarDelete.do?regNo=${vo.num}'">차량
					삭제</button>
				<button type="button" class="cancel-btn" onclick="history.back()">취소</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="/part/footer.jsp"%>