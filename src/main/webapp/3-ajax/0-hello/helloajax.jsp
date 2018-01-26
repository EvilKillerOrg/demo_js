<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello</title>

<script type="text/javascript">
    window.onload = function() {
	document.getElementsByTagName('a')[0].onclick = function() {
	    //1.创建XMLHttpRequest对象 
	    var request = new XMLHttpRequest();

	    //2.准备发送请求的数据 : url
	    var url = this.href + "?time=" + new Date(); //加个时间戳,每次url不一样,起到禁用缓存的目的

	    //3.调用XMLHttpRequest对象的 open 方法
	    var method = "GET";
	    request.open(method, url);
	    // 发送POST请求时要设置setRequestHeader('ContentType', 'application/x-www-form-urlencoded');
	    //request.setRequestHeader('ContentType', 'application/x-www-form-urlencoded');

	    //4.调用XMLHttpRequest对象的 send 方法
	    request.send(null); //null因为是GET请求
	    //request.send("name='ek'"); //这是发送POST请求

	    //5.为XMLHttpRequest对象添加 onreadystatechange 响应函数
	    request.onreadystatechange = function() {
		alert(request.readyState);
		//6.判断响应是否完成: XMLHttpRequest对象的 readystate 属性为4时 代表完成
		if (request.readyState == 4) {
		    //7.再判断响应是否可用: XMLHttpRequest对象的 status 属性为200或304时 代表可用
		    if (request.status == 200 || request.status == 304) {
			//8.打印响应结果: responseText
			alert(request.responseText);
		    }
		}
	    }
	    return false; //让<a>标签不跳转
	}
    }
</script>


</head>
<body>
	<a href="helloajax.txt">hello</a>
</body>
</html>