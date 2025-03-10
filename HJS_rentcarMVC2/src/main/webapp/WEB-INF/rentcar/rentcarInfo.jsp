<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<div class="container">
  <form id="car-form" action="${ctx}/resercationRentcar.do" method="post">
    <div class="car-desc">
      <div class="car-photo">
        <img alt="${vo.name}" src="./img/${vo.img}" class="car-image">
      </div>
      <div class="car-info-wrapper">
        <h2 class="car-info-title">차량 정보</h2>
        <p class="car-info">${vo.info}</p>
      </div>
    </div>
    <div class="car-table-wrapper">
      <table class="car-table">
        <tr>
          <td colspan="2">
            <h2 class="car-title">${vo.name} 차량 선택</h2>
          </td>
        </tr>
        <tr>
          <td class="colname">차량 수량</td>
          <td class="left"><select name="qty" id="qtyVal" class="select-field">
              <c:forEach var="i" begin="1" end="${vo.totalQty}">
                <option value="${i}">${i}</option>
              </c:forEach>
            </select></td>
        </tr>
        <tr>
          <td class="colname">차량 분류</td>
          <td class="left"><c:if test="${vo.category eq '1'}">
              <span class="category">소형</span>
            </c:if> <c:if test="${vo.category eq '2'}">
              <span class="category">중형</span>
            </c:if> <c:if test="${vo.category eq '3'}">
              <span class="category">대형</span>
            </c:if></td>
        </tr>
        <tr>
          <td class="colname">대여 가격</td>
          <td class="left"><span class="price">${vo.price}원</span></td>
        </tr>
        <tr>
          <td class="colname">제조 회사</td>
          <td class="left">${vo.company}</td>
        </tr>
      </table>
      <div class="btn-group">
        <input type="hidden" name="num" value="${vo.num}" />
        <input type="hidden" name="userId" value="${userId}" />
        <button type="submit" class="next-btn mybtn">
          옵션선택 후 구매하기 <span class="arrow">></span>
        </button>
      </div>
    </div>
  </form>
</div>
<%@ include file="/part/footer.jsp"%>