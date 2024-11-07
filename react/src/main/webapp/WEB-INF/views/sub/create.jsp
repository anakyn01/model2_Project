<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../../include/header.jsp" flush="false"/>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div id="create">
			
			</div>
		</div>
	</div>
</div>

<script type="text/babel">
const Create = () => {
 return(
<>
<h1 className="my-5">Write</h1>
<form method="post">
<div class="input-group my-3">
<label className="form-label">
컨텐츠 제목 :
</label>
<input type="text" name="title" className="form-control"/>
</div>

<div class="input-group my-3">
<label className="form-label">
컨텐츠 본문 :
</label>
<textarea name="content_body" className="form-control"></textarea>
</div>

<div class="d-flex justify-content-end">
<input type="submit" className="btn btn-outline-success btn-lg" value="쓰기"/>
</div>
</form>
</>
);
}

const root = ReactDOM.createRoot(document.getElementById('create'));
root.render(<Create/>)
</script>

<jsp:include page="../../include/footer.jsp" flush="false"/>
