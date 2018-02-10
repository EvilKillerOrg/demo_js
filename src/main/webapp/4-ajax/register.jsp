<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  var request;
  function validate() {
    var idField = document.getElementById("userid");
    var url = "validate.jsp?id=" + escape(idField.value);
    if (window.XMLHttpRequest) {
      request = new XMLHttpRequest(); //别的
    } else if (window.ActiveXObject) {
      request = new ActiveXObject("Microsoft.XMLHTTP"); //IE
    }
    request.open("GET", url, true); //true是异步
    request.onreadystatechange = callback;
    request.send(null);
  }

  function callback() {
    // alert("readyState: "+request.readyState);
    if (request.readyState == 4) { //readyState=4 只代表执行状态完成了
      if (request.status == 200) { //status=200 才代表正确执行了
        //alert(request.responseText);
        var msg = request.responseXML.getElementsByTagName("msg")[0];
        //alert(msg.childNodes[0].nodeValue);
        setMsg(msg.childNodes[0].nodeValue);
      }
    }
  }

  function setMsg(msg) {
    //alert(msg);
    var usermsg ;
    if(msg=="invalid"){
      usermsg = document.getElementById("usermsg").innerHTML="<font color='red'>用户名已存在</font>";
    }else{
      usermsg = document.getElementById("usermsg").innerHTML="<font color='green'>可以注册</font>";
    }
    
  }
</script>
</head>
<body>
  <table width="350" align="center" border="1">
    <tr>
      <td>用户名</td>
      <td>
        <input type="text" name="username" id="userid" onblur="validate();" />
        <div id="usermsg"></div>
      </td>
    </tr>
    <tr>
      <td>密码</td>
      <td><input type="text" name="password" /></td>
    </tr>
    <tr>
      <td>确认密码</td>
      <td><input type="text" name="confirm" /></td>
    </tr>
    <tr>
      <td>电话</td>
      <td><input type="text" name="phone" /></td>
    </tr>
    <tr>
      <td>地址</td>
      <td><textarea name="address" rows="10" cols="20"></textarea></td>
    </tr>
    <tr>
      <td><input type="submit" name="submit"></td>
      <td><input type="reset" name="reset" /></td>
    </tr>

  </table>
</body>
</html>