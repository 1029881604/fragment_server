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
        body{
            background: #efefef;
            font-size:18px;
        }
        .div-block{
            background: #ffffff;
            padding: 5px;
            margin-bottom: 10px;
        }
        .contentPadding{
        	padding-top:5px;
        	padding-bottom:5px;
        }
        h3{
            margin-top: 10px;
        }
        .head-img{
            width: 60px;
            height: 60px;
        }
        .span-block{
            display: block;
            overflow: hidden; 		/*溢出隐藏*/
            text-overflow:ellipsis;/*超出则加省略号*/
            white-space:nowrap;	/*规定段落中的文本不进行换行*/
        }
        .separate{
            border-bottom: 1px solid #eee;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        .img_sex{
        	margin-top:15px;
        	max-height: 30px;
        	max-width: 30px;	
        }
        button{
        	margin-top:5px;
        	margin-bottom:5px;
        	height:40px;
        }
        button span{
        	font-size:18px;
        }
    </style>
</head>
<body>
    <div class="container-fluid">
        <div class="div-block">
            <h3 class="text-center text-info">详细资料</h3>
        </div>
        <div class="col-xs-12 col-sm-12 div-block">
        	<div class="col-xs-1 col-sm-1">
                <c:set var="url" scope="request" value="sex_unknow.png"/>
                <c:if test="${nearby_personinfo.sex eq '男' }">
                	<c:set var="url" scope="request" value="sex_man.png" />
                </c:if>
                <c:if test="${nearby_personinfo.sex eq '女' }">
                	<c:set var="url" scope="request" value="sex_woman.png" />
                </c:if>
                <img src="images/commons/<c:out value='${url }' />" alt="img" class="img-responsive img_sex center-block" />
        	</div>
            <div class="col-xs-4 col-sm-4">
                <img src="${nearby_personinfo.headimg }" alt="img" class="head-img img-responsive img-circle center-block" />
            </div>
            <div class="col-xs-offset-4 col-sm-offset-4">
                <span class="text-nowrap span-block">昵称:&nbsp;&nbsp;${nearby_personinfo.name } </span>
                <span class="text-muted span-block">碎片号:&nbsp;&nbsp;${nearby_personinfo.id }</span>
            </div>
        </div>
        <div class="col-xs-12 col-sm-12 div-block text-info">
            <div class="col-xs-12 col-sm-12 contentPadding">
                邮箱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${nearby_personinfo.email }
            </div>
            
            <div class="col-xs-12 col-sm-12 separate"></div>
            
            <div class="col-xs-12 col-sm-12 text-nowrap contentPadding">
                星级&nbsp;&nbsp;&nbsp;&nbsp;${nearby_personinfo.starnum }
            </div>
            
            <div class="col-xs-12 col-sm-12 separate"></div>
           
            <div class="col-xs-12 col-sm-12 text-nowrap contentPadding">
                交易数&nbsp;&nbsp;&nbsp;&nbsp;${nearby_personinfo.dealnum }
            </div>
            
            <div class="col-xs-12 col-sm-12 separate"></div>
            
            <div class="col-xs-12 col-sm-12 text-nowrap contentPadding">
              粉丝数&nbsp;&nbsp;&nbsp;&nbsp;${nearby_personinfo.fansnum }
            </div>
        </div>

        <div class="col-xs-12 col-sm-12 div-block text-info">
            <button id="btn-follow" type="button" class="btn btn-success col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1" >
            	<span>添加关注</span>
            </button>
            <div class="col-xs-12 col-sm-12 separate"></div>
            <button id="btn-more-info" type="button" class="btn btn-default col-xs-10 col-xs-offset-1 col-sm-10 col-sm-offset-1">
            	<span>更多信息</span>       
           </button>
        </div>

    </div>
</body>
<script type="text/javascript">
	$(function(){
		$("#btn-follow").click(function(e){
			$(this).attr("disabled", true);
			setTimeout(function() {
				$("#btn-follow").attr("disabled", false);
			}, 2000);
			window.location.href="person/followPerson.do?id=${nearby_personinfo.id}";
		});
		$("#btn-more-info").click(function(e){
			window.location.href="person/getPersonDetail.do?id=${nearby_personinfo.id}";
		});
	});
	
</script>
</html>