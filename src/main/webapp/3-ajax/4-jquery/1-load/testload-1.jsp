<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试load()方法-1(解析文件)</title>

<script type="text/javascript" src="${pageContext.request.contextPath }/common/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("a").click(function() {
			//使用load()方法处理Ajax
			var url = this.href;
			var args = {
				"time" : new Date()
			}; //时间戳,防止缓存 jQuery中使用JSON格式
			$("#content").load(url, args); //url后面加上参数就成POST了,不加是GET

			return false; //取消默认行为
		});
	});
</script>

</head>
<body>
	<a href="file/helloajax.txt">HelloAjax</a>
	<div id="content">
		<!-- 使用jQuery的load()方法,读取文件放在这里 -->
	</div>
</body>
</html>