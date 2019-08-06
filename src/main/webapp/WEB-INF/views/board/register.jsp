<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>

</head>
<div style="min-height : 561px">
<h1>게시글 등록</h1>
	<form method="post" action="<%=request.getContextPath()%>/board/register" enctype="multipart/form-data">
		<div class="form-group">
		  <input type="text" class="form-control" name="title" placeholder="제목">
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" name="writer" value="${user.id}" readonly>
		</div>
		<textarea name="contents" id="summernote"></textarea>
		<input type="file" class="form-control-file border" name="file2">
		<button type="submit" class="btn btn-outline-info">등록</button>
	</form>
</div>
<script>
	$(document).ready(function(){
		$('#summernote').summernote({
		       placeholder: 'Hello bootstrap 4',
		       tabsize: 2,
		       height: 100,
		       lang: 'ko-KR'
		     });
	});
</script>