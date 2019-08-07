<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<html lang="en">
<head>
	<title>회원가입</title>
	<style>
	*{
		margin: 0;
		padding : 0;
	}
	.main{
		margin-top:50px;
	}
	.row{
		margin: 5px 0px;
	}
	.fab.fa-amazon{
		font-size: 100px;
		color: red;
	}
	</style>
	<script type="text/javascript">
		var isCheck = false;
		
		$(document).ready(function(){
			
			$('#signup').submit(function(){
				if(!isCheck){
					alert('아이디 중복검사를 하세요 ')
					return false;
			}
		});
			
			$('#dup').click(function(){
				var id=$('input[name=id]').val(); //서버로 아이디값을 보내기 위해 입력받은 아이디의 정보를 가져오고 
				
				$.ajax({
			        async:true, //비동기방식
			        type:'POST',
			        data:id, //{'id':id}
			        url: "<%=request.getContextPath()%>"+"/dup",
			        dataType:"json",
			        contentType:"application/json; charset=UTF-8",
			        success : function(data){ 
			            if(!data){
			            	alert('회원가입이 가능한 아이디입니다.');
			            	isCheck=true;
			            }else{
			            	alert('이미 가입된 회원입니다.');
			            	isCheck=false;
			            }
			        }
			    });
			});
			$('input[name=id]').change(function(){
				isCheck= false;
			});
		});	
	</script>
</head>
<body>
	<div>
		<div class="offset-4 col-4 border border-dark mt-5">
			<h1 class="text-center">회원가입</h1>
			<form method="post" action="" id="signup"><!-- 개인정보니까 post로  액션따로지정안하면 현재페이지로?????-->
				<div class="row">
					<label class="col-4" >아이디</label>
					<input type="text"class="form-control col-7" name="id" placeholder="아이디">
					
				</div>
				<div>
					<label id="id-error" class="offset-4 col-7 error p-0" for="id"></label>
				</div>
				<div>
					<button type="button" class="btn btn-outline-success offset-4 col-7" id="dup">아이디 중복확인</button>
				</div>
				<div class="row">
					<label class="col-4">비밀번호</label>
					<input type="password"class="form-control col-7" name="pw" placeholder="비밀번호" id="pw">
				</div>
				<div class="row">
					<label class="col-4">비밀번호확인</label>
					<input type="password"class="form-control col-7" name="pw2"placeholder="비밀번호확인">
				</div>
				<div class="row">
					<label class="col-4">성별</label>
					<div class="col-8">
						<label class="form-check-label col-5">
							<input type="radio" class="form-check-input" name="gender" value="M" checked>남성
						</label>
						<label class="form-check-label">
							<input type="radio" class="form-check-input" name="gender" value="F">여성
						</label>
					</div>
				</div>
				<div class="row">
					<label class="col-4">이메일</label>
					<input type="email"class="form-control col-7" name="email" placeholder="이메일">
				</div>
				<div class="offset-8 col-3 clearfix p-0">
					<button class="btn btn-primary float-right">가입</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>