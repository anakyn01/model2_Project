<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% pageContext.setAttribute("CRLF", "\r\n"); %>

<jsp:include page="../../include/header.jsp" flush="false"/>

<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div id="read">
			
			</div>
		</div>
	</div>
</div>

<script type="text/babel">
const Read = () => {
return(
<>
<div className="input-group">
<label className="form-label">
글번호
</label>
<p>${reactCont.BLG_CONT_SEQ}</p>
</div>
<hr/>
<div className="input-group">
<label className="form-label">
제목
</label>
<p>${reactCont.TITLE}</p>
</div>
<div>
<p>내용</p>
<div>
${fn:replace(reactCont.CONT_BDY, CRLF, '<br/>')}
</div>
</div>
<hr/>
<div className="input-group">
<label className="form-label">
입력일 
</label>
<fmt:formatDate value="${reactCont.INSERT_DT}" pattern="yyyy.MM.dd HH:mm:ss"/>
</div>
</>
);
}

const root = ReactDOM.createRoot(document.getElementById('read'));
root.render(<Read/>)
</script>

<jsp:include page="../../include/footer.jsp" flush="false"/>
