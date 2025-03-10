<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<div class="reservation-container">
  <div class="car-list">
    <h2 class="reservation-title">예약 정보 확인</h2>
    <table class="reserve-table">
      <thead>
        <tr>
          <th>이미지</th>
          <th>이름</th>
          <th>대여일</th>
          <th>대여기간</th>
          <th>반납일</th>
          <th>총 금액</th>
          <th>수량</th>
          <th>보험</th>
          <th>와이파이</th>
          <th>베이비시트</th>
          <th>네비게이션</th>
          <th>수정</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="vo" items="${list}">
          <tr>
            <td data-label="이미지"><img src="./img/${vo.img}" alt="${vo.name}" class="reserve-image"></td>
            <td data-label="이름">${vo.name}</td>
            <td data-label="대여일">${vo.rday}</td>
            <td data-label="대여기간">${vo.dday}일</td>
            <td data-label="반납일">${vo.endDate}</td>
            <td data-label="총 금액">${vo.totalPrice}원</td>
            <td data-label="수량">${vo.qty}</td>
            <td data-label="보험">
              <c:choose>
                <c:when test="${vo.usein eq 0}">
                  <span class="option off">미적용</span>
                </c:when>
                <c:otherwise>
                  <span class="option on">적용</span>
                </c:otherwise>
              </c:choose>
            </td>
            <td data-label="Wifi">
              <c:choose>
                <c:when test="${vo.usewifi eq 0}">
                  <span class="option off">미적용</span>
                </c:when>
                <c:otherwise>
                  <span class="option on">적용</span>
                </c:otherwise>
              </c:choose>
            </td>
            <td data-label="BabySeat">
              <c:choose>
                <c:when test="${vo.useseat eq 0}">
                  <span class="option off">미적용</span>
                </c:when>
                <c:otherwise>
                  <span class="option on">적용</span>
                </c:otherwise>
              </c:choose>
            </td>
            <td data-label="Navigation">
              <c:choose>
                <c:when test="${vo.usenavi eq 0}">
                  <span class="option off">미적용</span>
                </c:when>
                <c:otherwise>
                  <span class="option on">적용</span>
                </c:otherwise>
              </c:choose>
            </td>
            <td data-label="수정">
              <button class="edit-btn" onclick="location.href='${ctx}/updateRes.do?regNo=${vo.regNo}'">예약 수정</button>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<%@ include file="/part/footer.jsp"%>