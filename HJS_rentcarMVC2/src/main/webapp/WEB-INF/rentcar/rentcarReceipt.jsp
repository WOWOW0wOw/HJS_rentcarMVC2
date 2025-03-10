<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<form action="${ctx}/reservationComplete.do" method="post">
  <div class="modal car-modal">
    <div class="modal-content">
      <div class="desc-header">
        <h2 class="modal-title">차량 예약을 확인해주세요</h2>
      </div>
      <div class="car-result">
        <table class="result-table">
          <tr>
            <th>차량 예약일</th>
            <td colspan="2" id="rday">${rday}</td>
          </tr>
          <tr>
            <th>차량 갯수</th>
            <td colspan="2" id="qty">${qty}</td>
          </tr>
          <tr>
            <th>차량 총 예약일</th>
            <td id="dday">${dday}</td>
            <td id="ddays">${dday * price}원</td>
          </tr>
          <tr>
            <th>차량 총 유료 옵션</th>
            <td id="carOptionsCnt">${(usein + useseat + usewifi + usenavi)}</td>
            <td id="carOptions">${(usein + useseat + usewifi) * 10000}원</td>
          </tr>
          <tr>
            <th>차량 총액 합산</th>
            <td colspan="2" id="carTotals">${((usein + useseat + usewifi) * 10000 + price) * dday}원</td>
          </tr>
          <tr>
            <td colspan="3">
              <input type="hidden" name="num" id="num" value="${num}" />
              <input type="hidden" name="log" id="log" value="${log}" />
              <input type="hidden" name="qty" id="qty" value="${qty}" />
              <input type="hidden" name="usein" id="usein" value="${usein}" />
              <input type="hidden" name="usewifi" id="usewifi" value="${usewifi}" />
              <input type="hidden" name="usenavi" id="usenavi" value="${usenavi}" />
              <input type="hidden" name="useseat" id="useseat" value="${useseat}" />
              <input type="hidden" name="dday" id="dday" value="${dday}" />
              <input type="hidden" name="rday" id="rday" value="${rday}" />
            </td>
          </tr>
          <tr>
            <td colspan="3" class="btn-container">
              <button type="submit" id="updateBtn" class="next-btn">예약 확인</button>
            </td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</form>
<%@ include file="/part/footer.jsp"%>