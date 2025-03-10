<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp" %>

<h1>차량추가</h1>
<div class="rentcarAdd-container">
	<form class="car-insert-form" action="${ ctx }/rentcarinsert.do?" method="post" enctype="multipart/form-data">
		<div class="car-insert-sec">
			<div class="car-insert-input">
				<label for="carName">차량명</label>
				<input name="carName" id="carName" type="text"/>
			</div>
			<div class="car-insert-input">
				<label class="insert-category" for="carCategory">카테고리</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="1" checked/>소형</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="2" />중형</label>
				<label><input name="carCategory" id="carCategory" type="radio" value="3" />대형</label>
			</div>
			<div class="car-insert-input">
				<label for="carPrice">가격</label>
				<input name="carPrice" id="carPrice" type="number" min="1" />
			</div>
			<div class="car-insert-input">
				<label for="carUsepeople">최대 수용 인원</label>
				<input name="carUsepeople" id="carUsepeople" type="number" min="1" />
			</div>
			<div class="car-insert-input">
				<label for="carTotalQty">재고</label>
				<input name="carTotalQty" id="carTotalQty" type="number" min="1" />
			</div>
			<div class="car-insert-input">
				<label for="carCompany">회사</label>
				<label><input name="carCompany" id="carCompany" type="radio" value="기아" checked/>기아</label>
				<label><input name="carCompany" id="carCompany" type="radio" value="현대" />현대</label>
				<label><input name="carCompany" id="carCompany" type="radio" value="BMW" />BMW</label>
			</div>
			<div class="car-insert-input">
				<label for="carInfo">차량정보</label>
				<textarea name="carInfo" id="carInfo"></textarea>
			</div>
			<div class="car-insert-input">
				<label for="carImg">이미지</label>
				<input name="carImg" id="carImg" type="file" accept="image/*"/>
			</div>
			<div class="car-insert-submit">
				<button class="btn-car-insert">등록하기</button>
			</div>
		</div>
	</form>
</div>
<%@ include file="/part/footer.jsp" %>