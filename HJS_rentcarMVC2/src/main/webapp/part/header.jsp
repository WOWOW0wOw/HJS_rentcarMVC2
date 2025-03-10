<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>렌트카</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
</head>
<body>
	<div class="wrapper">
		<header>
			<div class="inner">
				<nav class="gnb">
					<a href="${ctx}/main.do" class="logo"><img src="img/logo.jpg"
						alt="logo" width="100px"></a>
					<div class="nav-links">
						<c:if test="${log eq -1}">
							<a href="${ctx}/userList.do" class="nav-btn"><span>회원
									목록</span></a>
							<a href="${ctx}/rentcarAdd.do" class="nav-btn"><span>차량
									추가</span></a>
						</c:if>
						<c:if test="${log eq null}">
							<a href="${ctx}/insertUser.do" class="nav-btn"><span>회원
									가입</span></a>
							<a href="${ctx}/userLogin.do" class="nav-btn"><span>로그인</span></a>
						</c:if>
						<c:if test="${log ne null}">
							<a href="${ctx}/userLogout.do" class="nav-btn"><span>로그아웃</span></a>
							<c:if test="${log ne -1}">
							<a href="${ctx}/userContent.do?num=${log}" class="nav-btn"><span>내정보</span></a>
							</c:if>
						</c:if>
						<a href="${ctx}/rentcarList.do" class="nav-btn"><span>차량
								조회</span></a> <a href="${ctx}/reservationList.do?loginId=${loginId}"
							class="nav-btn"><span>예약 확인</span></a> <a
							href="https://www.police.go.kr/www/security/cyber.jsp" class="nav-btn"><span>빠른 상담</span></a>
					</div>
				</nav>
			</div>
		</header>
		<main class="main-content">