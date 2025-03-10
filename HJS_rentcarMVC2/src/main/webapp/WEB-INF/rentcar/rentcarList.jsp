<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/part/header.jsp"%>
<div class="inner">
	<form action="#" method="post">
		<p>
			<nav id="cateMenu">
				<ul class="menu">
					<li class="dropdown"><a href="${ctx}/rentcarList.do">전체</a>
						<ul class="submenu">
							<li><a href="${ctx}/rentcarList.do?cat=1">소형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=2">중형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=3">대형</a></li>
						</ul></li>
					<li class="dropdown"><a href="${ctx}/rentcarList.do?com=현대">현대</a>
						<ul class="submenu">
							<li><a href="${ctx}/rentcarList.do?cat=1&com=현대">소형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=2&com=현대">중형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=3&com=현대">대형</a></li>
						</ul></li>
					<li class="dropdown"><a href="${ctx}/rentcarList.do?com=기아">기아</a>
						<ul class="submenu">
							<li><a href="${ctx}/rentcarList.do?cat=1&com=기아">소형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=2&com=기아">중형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=3&com=기아">대형</a></li>
						</ul></li>
					<li class="dropdown"><a href="${ctx}/rentcarList.do?com=BMW">BMW</a>
						<ul class="submenu">
							<li><a href="${ctx}/rentcarList.do?cat=1&com=BMW">소형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=2&com=BMW">중형</a></li>
							<li><a href="${ctx}/rentcarList.do?cat=3&com=BMW">대형</a></li>
						</ul></li>
				</ul>
			</nav>
		</p>
	</form>

	<div class="car-content">
		<h2>${title}조회</h2>
		<div class="itemWrap">
			<c:forEach var="vo" items="${list}">
				<input type="hidden" name="num" id="num" value="${vo.num}">
				<div class="item"
					onclick="checkQty('${vo.totalQty}','${ctx}','${vo.num}','${loginId}')">
					<div class="imgBox">
						<img src="${ctx}/img/${vo.img}" alt="${vo.name}">
					</div>
					<div class="textBox">
						<p class="textBox__name">${vo.name}&nbsp;(${vo.company})</p>
						<p class="textBox__price">${vo.price}원</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>

<script>
	function checkQty(qty, ctx, num, loginId) {
		if (loginId == 'admin') {
			location.href = ctx + '/rentcarUpdate.do?num=' + num;
		}
		if (qty > 0) {
			location.href = ctx + '/rentcarInfo.do?num=' + num;
		} else {
			alert('죄송합니다 이 차는 모두 렌트 중입니다');
		}
	}
</script>

<%@ include file="/part/footer.jsp"%>
