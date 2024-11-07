<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="include/header.jsp" flush="false"/>
<video width="" height="" controls class="w-100">
<source src="${path}/resources/motion/coffee.mp4" type="video/mp4">
</video>
<jsp:include page="include/slide.jsp" flush="false"/>
<jsp:include page="include/footer.jsp" flush="false"/>