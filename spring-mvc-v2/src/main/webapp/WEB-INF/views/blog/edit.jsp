<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="../include/header.jsp" flush="false"/>
<div class="container">
<div class="row">
<div class="col-md-12">
<h1 class="my-5">update</h1>
<ul class="breadcrumb mb-3">
<li class="breadcrumb-item"><a href="/list">HOME</a></li>
<li class="breadcrumb-item active">update</li>
</ul>
    <form method="post">
        <input type="hidden" name = "_method" value = "put"/>
        <p>글번호 : ${blogCont.BLG_CONT_SEQ}</p>
        <p class="input-group">
            <label class="form-label">컨텐츠 제목 :</label>
            <input type='text' name='title' class="form-control" value="${blogCont.TITLE}" />
        </p>
        <p>
            본문
        </p>
        <p>
            <textarea rows="10" name="contBdy" class="form-control">${blogCont.CONT_BDY}</textarea>
        </p>
        <p>입력일 : <fmt:formatDate value="${blogCont.INSERT_DT}" pattern="yyyy.MM.dd HH:mm:ss" /></p>
        <div class="d-flex justify-content-end my-5">
	        <div class="btn-group">
		        <a href="/list" class="btn btn-outline-secondary">list</a>
		        <input type="submit" name="create" value="블로그 컨텐츠 수정" class="btn btn-outline-success"/> 
	        </div>            
        </div>
                
    </form>
</div>
</div>
</div>
<jsp:include page="../include/footer.jsp" flush="false"/>