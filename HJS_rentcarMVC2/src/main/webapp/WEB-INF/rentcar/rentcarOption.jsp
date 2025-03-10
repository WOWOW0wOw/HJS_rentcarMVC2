<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/carform.css">
<main>
	<div class="option-container">
		<form id="car-form" action="${ctx}/rentcarReceipt.do" method="post"
			id="optionForm">
			<div class="car-desc">
				<h2 class="car-title">${car.name}대여 옵션 선택</h2>
				<div class="car-photo">
					<img src="./img/${car.img}" class="car-image">
					<p id="price" data-price="${car.price}" class="price-text">
						하루 렌트 당 가격 <span class="price">${car.price}원</span>
					</p>
				</div>
			</div>
			<div class="car-table-wrapper">
				<table class="car-table">
					<tr>
						<td class="colname">대여기간</td>
						<td class="left"><select name="dday" id="dday"
							class="select-field">
								<c:forEach var="i" begin="1" end="7">
									<option value="${i}">${i}일</option>
								</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="colname">대여일</td>
						<td class="left"><input type="date" name="rday" id="rday"
							class="input-field"></td>
					</tr>
					<tr>
						<td class="colname">보험적용</td>
						<td class="left"><select name="usein" id="usein"
							class="select-field">
								<option value="1">적용(1일 1만원)</option>
								<option value="0">비적용</option>
						</select></td>
					</tr>
					<tr>
						<td class="colname">Wifi 적용</td>
						<td class="left"><select name="usewifi" id="usewifi"
							class="select-field">
								<option value="1">적용(1일 1만원)</option>
								<option value="0">비적용</option>
						</select></td>
					</tr>
					<tr>
						<td class="colname">네비게이션 적용</td>
						<td class="left"><select name="usenavi" id="usenavi"
							class="select-field">
								<option value="1">적용(무료)</option>
								<option value="0">비적용</option>
						</select></td>
					</tr>
					<tr>
						<td class="colname">베이비시트 적용</td>
						<td class="left"><select name="useseat" id="useseat"
							class="select-field">
								<option value="1">적용(1일 1만원)</option>
								<option value="0">비적용</option>
						</select></td>
					</tr>
				</table>
				<div class="btn-group">
					<input type="hidden" name="num" id="num" value="${car.num}" /> <input
						type="hidden" name="userId" id="userId" value="${userId}">
					<input type="hidden" name="qty" id="qty" value="${qty}"> <input
						type="hidden" name="price" id="price" value="${car.price}">
					<button type="submit" class="next-btn mybtn">
						차량 예약 하기 <span class="arrow">></span>
					</button>
				</div>
			</div>
		</form>
	</div>
</main>
<%@ include file="/part/footer.jsp"%>
<script src="${ctx}/js/carOption.js"></script>