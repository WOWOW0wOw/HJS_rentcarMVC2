<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<div class="reservation-update-container">
  <h2 class="update-title">예약 수정</h2>
  <c:if test="${vo ne null}">
    <form action="${ctx}/updateSetRes.do" method="post" class="update-form">
      <div class="update-table-wrapper">
        <table class="update-table">
          <tr>
            <th>예약자</th>
            <td>${vo.name}</td>
          </tr>
          <tr>
            <th>수량</th>
            <td class="left"><select name="qty" id="qtyVal" class="select-field">
                <c:forEach var="i" begin="1" end="${vo.qty}">
                  <option value="${i}">${i}</option>
                </c:forEach>
              </select></td>
          </tr>
          <tr>
            <th>대여 기간</th>
            <td><select name="dday" class="select-field">
                <c:forEach var="i" begin="1" end="7">
                  <option value="${i}" ${vo.dday == i ? 'selected' : ''}>${i}일</option>
                </c:forEach>
              </select></td>
          </tr>
          <tr>
            <th>대여 일자</th>
            <td><input type="date" name="rday" id="rday" class="input-field" value="${vo.rday}"></td>
          </tr>
          <tr>
            <th>보험</th>
            <td><select name="usein" class="select-field">
                <option value="1" ${vo.usein == 1 ? 'selected' : ''}>적용</option>
                <option value="0" ${vo.usein == 0 ? 'selected' : ''}>미적용</option>
              </select></td>
          </tr>
          <tr>
            <th>Wifi</th>
            <td><select name="usewifi" class="select-field">
                <option value="1" ${vo.usewifi == 1 ? 'selected' : ''}>적용</option>
                <option value="0" ${vo.usewifi == 0 ? 'selected' : ''}>미적용</option>
              </select></td>
          </tr>
          <tr>
            <th>네비게이션</th>
            <td><select name="usenavi" class="select-field">
                <option value="1" ${vo.usenavi == 1 ? 'selected' : ''}>적용</option>
                <option value="0" ${vo.usenavi == 0 ? 'selected' : ''}>미적용</option>
              </select></td>
          </tr>
          <tr>
            <th>베이비시트</th>
            <td><select name="useseat" class="select-field">
                <option value="1" ${vo.useseat == 1 ? 'selected' : ''}>적용</option>
                <option value="0" ${vo.useseat == 0 ? 'selected' : ''}>미적용</option>
              </select></td>
          </tr>
        </table>
        <div class="btn-group">
          <input type="hidden" name="regNo" value="${vo.regNo}">
          <input type="hidden" name="loginId" value="${loginId}">
          <button type="submit" class="submit-btn">수정 완료</button>
          <button type="button" class="delete-btn" onclick="location.href='${ctx}/deleteRes.do?regNo=${vo.regNo}'">예약 취소</button>
          <button type="button" class="cancel-btn" onclick="history.back()">취소</button>
        </div>
      </div>
    </form>
  </c:if>
</div>
<%@ include file="/part/footer.jsp"%>
<script src="${ctx}/js/carOption.js"></script>