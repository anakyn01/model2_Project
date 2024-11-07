<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="btn" data-bs-toggle="collapse" href="#collapseOne">
          성별
        </a>
      </div>
      <div id="collapseOne" class="collapse show" data-bs-parent="#accordion">
        <div class="card-body">
        	<a href="#" class="a-link">남성</a><br/>
        	<a href="#" class="a-link">여성</a><br/>
        	<a href="#" class="a-link">유니섹스</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseTwo">
        키즈
      </a>
      </div>
      <div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
        <div class="card-body">
            <a href="#" class="a-link">남아</a><br/>
        	<a href="#" class="a-link">여아</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed btn" data-bs-toggle="collapse" href="#collapseThree">
          키즈연령
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-bs-parent="#accordion">
        <div class="card-body">
            <a href="#" class="a-link">베이비(0-3세)</a><br/>
        	<a href="#" class="a-link">베이비(3-7세)</a><br/>
        	<a href="#" class="a-link">주니어(7-15세)</a>
        </div>
      </div>
    </div>
  </div>