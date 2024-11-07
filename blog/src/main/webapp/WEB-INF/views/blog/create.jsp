<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<div class="container">
	<div class="row">
		<div class="col-md-12">
<div class="p-5">
			<form method="post">
				<div class="input-group my-3">
					<label class="form-label">
					컨텐츠 제목 : 
					</label>
					<input type="text" name="title" class="form-control">
				</div>	
				<div class="input-group my-3">
					<label class="form-label">
					컨텐츠 본문 : 
					</label>
					<textarea rows="5" name="content_body" class="form-control"></textarea>
				</div>	
				<div class="d-flex justify-content-end">
				<input type="submit" name="create" class="btn btn-outline-success" value="블로그 컨텐츠 쓰기"/>
				</div>	
			</form>
</div>
		</div>
	</div>
</div>


<%@ include file="include/footer.jsp" %>