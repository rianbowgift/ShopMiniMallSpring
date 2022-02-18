<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
   
    	 $("form").on("submit",function(event){		
    		 var userid = $("#userid").val();
    		 var passwd = $("#passwd").val();
    	    		if(userid.length==0){
    	    			alert("userid 필수")
    	    			$("#userid").focus();
    	    			event.preventDefault();
    	    		}else if(passwd.length==0){
    	    			alert("passwd 필수")
    	    			$("#passwd").focus();
    	    			event.preventDefault();
    	    		}
    	    	});
   });
</script>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${! empty mesg}">
	<script type="text/javascript">
	  alert("${mesg}")
	</script>
</c:if>
<form action="login" method="get">
아이디:<input type="text" name="userid" id="userid"><br>
비밀번호:<input type="text" name="passwd" id="passwd"><br> 
<input type="submit" value="로그인">
<input type="reset" value="취소">
<a href="MemberIdSearchUIServlet">아이디찾기</a>
</form>
