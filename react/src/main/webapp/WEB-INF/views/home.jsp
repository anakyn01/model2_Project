<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="../include/header.jsp" flush="false"/>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div id="print">
			
			</div>
		</div>
	</div>
</div>

<script type="text/babel">
function Main(){
return (//html코드 쓰는곳
<>
<div id="demo" class="carousel slide" data-bs-ride="carousel">

  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" className="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>

  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="resources/img/la.jpg" alt="Los Angeles" className="w-100"/>
    </div>
    <div class="carousel-item">
      <img src="resources/img/chicago.jpg" alt="Chicago" className="w-100"/>
    </div>
    <div class="carousel-item">
      <img src="resources/img/ny.jpg" alt="New York" className="w-100"/>
    </div>
  </div>

  <button className="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
    <span className="carousel-control-prev-icon"></span>
  </button>
  <button className="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
    <span className="carousel-control-next-icon"></span>
  </button>
</div>
</>
);
}

const root = ReactDOM.createRoot(document.getElementById('print'));
//상수 루트 = 리액트DOM.도큐먼트에서 아아디 프린트를 찾음
root.render(<Main/>);
</script>

<jsp:include page="../include/footer.jsp" flush="false"/>
