<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>

</head>
<div style="min-height : 561px">
<h1>게시글 수정</h1>
	<form method="post" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data"> <!-- encType가 있어야 서버에 첨부파일을 전송 -->
	<input type="hidden" value="${board.num}" name="num">
		<div class="form-group">
		  <input type="text" class="form-control" name="title" value="${board.title}">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
		</div>
		<textarea name="contents" id="summernote">${board.contents}</textarea>
		<div class="form-group">
		  <label>첨부파일</label>
		  <c:if test="${board.fileName ne '' }">
		  	<a href="<%=request.getContextPath()%>/board/download?fileName=${board.file}" id="fileLink">${board.fileName}</a>
		  	<input type="hidden" name="file" value="${board.file}"> <!--기존 첨부파일을 삭제하기위한,수정하기 버튼을 눌렀을때 기존 첨부파일을 덮어쓸지 지워줄지 유지할지 판별하기 위해-->
		  	<i class="fas fa-times close"></i>
		  </c:if>
		  <c:if test="${board.fileName eq '' }">
		  	없음
		  </c:if>
		</div>
		<input type="file" class="form-control-file border" name="file2">
		<button type="submit" class="btn btn-outline-info">수정하기</button>
	</form>
</div>
<script>
	$(document).ready(function(){
		$('#summernote').summernote({
		       placeholder: 'Hello bootstrap 4',
		       tabsize: 2,
		       height: 300,
		       lang: 'ko-KR'
	     });
		$('.close').click(function(){
			$('#fileLink').remove();
			$('input[name=file]').val('');
			$(this).css('display','none');
		});
	});
</script>