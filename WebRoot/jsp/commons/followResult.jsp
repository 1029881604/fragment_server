<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%= basePath %>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>personInfo</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
 <style type="text/css">
		 html {
		  height: 100%;
		}
		
        body{
            background: url("images/commons/bg_shalou.png");
            background-attachment: fixed;
            background-size:inherit;
            background-repeat:no-repeat;
            background-position:center center;
            font-size:18px;
		 	height: 100%;
		 	width: 100%;
		 	margin:0px;
        }
        .col-center-block {  
	    	float: none;  
		    display: block;  
		    margin-left: auto;  
		    margin-right: auto;  
		    margin-top:50%;
		} 
		#content{
			color:orange;
		}
    </style>
</head>
<body>
    <div class="container-fluid"> 
		 <div class="col-center-block text-center" id="content">
		 	<h2 class="text-center" >${ follow_status}</h2>
		 	<div><small id="sp" ></small></div>
		 </div>
    </div>
</body>
<script type="text/javascript">  
    window.onload=function(){  
        setInterval(go, 1000);  
    };  
    var x=4; //利用了全局变量来执行  
    function go(){  
 		   x--;  
        if(x>0){  
        	document.getElementById("sp").innerHTML=x+"秒后跳转页面..";  //每次设置的x的值都不一样了。  
        }else{  
        	history.back();
        }  
    }  
    
</script> 
</html>