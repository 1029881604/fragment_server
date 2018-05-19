<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

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
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
	 body{
        background: #fff;
        font-size:16px;
     }
     /*导航start*/
     .navbar{
     	margin-top:-1px;
     	font-size:35px;
     	line-height:50px;
     	background: #fcb2c9;
     }
     .my{
     	display:block;
     	position:absolute;
     	text-decoration:none;
     }
     .navbar #my_back{
     	font-size:18px;
     	left:5%;
     }
     .navbar #my_forward{
     	font-size:18px;
     	left:18%;
     }
     .navbar #my_reload{
     	left:35%;
     	font-size:18px;
     }
      .navbar #my_list{
     	height:30px;
     	line-height:60px;
     	right:30%;
     	bottom: 25%;
     }
     .navbar #my_list li{
     	margin-bottom:10px;
     	font-size:16px;
     }
     .navbar #my_list li a{
     	color: #ac75d2;
     }
     .navbar #my_close{
     	font-size:18px;
     	right:5%;
     }
     
     /*关注列表start*/
     .followed-info-box{
     	height:auto;
     	width:100%;
     	overflow: hidden;
     }
     .followed-sex-img-box{
     	width:10%;
     	display:block;
     	float:left;
     	max-height: 20px;
     	max-width: 20px;
     }
     .followed-sex-img{
     	float:left;
     	width:20px;
     	height: 20px;
     }
     .followed-head-img-box{
     	float:left;
     	width:20%;
     	max-height: 30px;
     	max-width: 30px;
     	margin-left:10px;
     }
     .followed-head-img{
     	float:left;
     }
	 .followed-other-box{
     	float:left;
     	width:75%;
     	margin-left:10px;
	 }
     .followed-other-box .span-block{
	 	clear:left;
     	float:left;
        display: block;
     	font-size:16px;
        overflow: hidden; 		/*溢出隐藏*/
        text-overflow:ellipsis;/*超出则加省略号*/
        white-space:nowrap;	/*规定段落中的文本不进行换行*/
     }
     .followed-other-box .span-block2{
     	float:right;
     	margin-right:5px;
     	font-size:14px;
     	color:#3385ff;
    	display: block;
        overflow: hidden; 		/*溢出隐藏*/
        text-overflow:ellipsis;/*超出则加省略号*/
        white-space:nowrap;	/*规定段落中的文本不进行换行*/
     }
     .text-user-name{
     	color:#FFCA28;
     }
     /*评论区css*/
     .comment{
     	margin-top:20px;
     	border:0;
     	overflow: hidden;
     }
     .comment .comment-item{
     	padding-bottom:10px;
     	width:100%;
     }
     .head-img{
     	padding:2px;
     }
     .head-img .img-responsive{
     	height:40px;
     	max-width: 200%;
     	width:40px;
     }
     .first-level{
     	line-height: 40px;
     }
     .third-level{
     	font-size:14px;
     	color:#666;
     	border-bottom: 1px solid #dddddd;
     }
     .title{
     	margin-top:60px;
     }
     
</style>
</head>
<body>
	<!-- 前进、后退 -->
	<nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container">
	  	<a id="my_back" class="my" onclick="func_back()"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></a>
	    <a id="my_forward" class="my" onclick="func_forward()"><span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
	    <a id="my_reload" class="my" onclick="func_reload()"><span class="glyphicon glyphicon-refresh" aria-hidden="true"></span></a>
	    <div id="my_list" class="my btn-group">
		  <button type="button" class="btn btn-sm btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		    操作 <span class="caret"></span>
		  </button>
		  <ul class="dropdown-menu">
		    <li>
		    	<a href="#"  data-toggle="modal" data-target="#commentModal" data-whatever="@${needExpand.id }">
		    		<span class="glyphicon glyphicon-comment" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;&nbsp;去评论
		    	</a>
		    </li>
		    <li><a href="#"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;&nbsp;点赞</a></li>
		    <li><a href="#"><span class="glyphicon glyphicon-bookmark" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;&nbsp;收藏</a></li>
		    <li role="separator" class="divider"></li>
		    <li><a href="#"><span class="glyphicon glyphicon-share" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;&nbsp;分享</a></li>
		  </ul>
		</div>
	    <a id="my_close" class="my" onclick="func_close()"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
	  </div>
	</nav>
	<div class="container-fluid">
		<div class="title">
            <h4 class="text-center text-info">详细信息</h4>
        </div>
		
		<ul class="list-group">
		  <li class="list-group-item active">ta关注的</li>
		  <c:forEach items="${followedUsers }" var="user">
		  <li class="list-group-item btn-go-user-info" value="${user.id }">
		  	<div class="followed-info-box">
	        	<div class="followed-sex-img-box">
	                <c:set var="url" scope="request" value="sex_unknow.png"/>
	                <c:if test="${user.sex eq '男' }">
	                	<c:set var="url" scope="request" value="sex_man.png" />
	                </c:if>
	                <c:if test="${user.sex eq '女' }">
	                	<c:set var="url" scope="request" value="sex_woman.png" />
	                </c:if>
	                <img src="images/commons/<c:out value='${url }' />" alt="img" class="img-responsive followed-sex-img center-block" />
	        	</div>
	            <div class="followed-head-img-box">
	                <img src="${user.headimg }" alt="img" class="img-responsive img-circle center-block followed-head-img" />
	            </div>
	            <div class="followed-other-box">
	                <span class="text-nowrap span-block">昵称:&nbsp;&nbsp;<span class="text-user-name">${user.name }</span> </span>
	                <span class="text-muted span-block">碎片号:&nbsp;&nbsp;${user.id }</span>
	                <span class="text-muted span-block2">时间:&nbsp;&nbsp;
	                	<fmt:formatDate value="${user.followTime }" pattern="yy/MM/dd HH:mm"/>
	                </span>
	            </div>
	        </div>
		  </li>
		  </c:forEach>
		</ul>
        
		<!-- Modal start -->
		<div class="modal fade" id="commentModal" tabindex="-1" role="dialog" aria-labelledby="commentModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="commentModalLabel">评论主题</h4>
		      </div>
		      <div class="modal-body">
		        <form>
		          <div class="form-group">
		            <label for="recipient-name" class="control-label">主题id:</label>
		            <input type="text" class="form-control" id="recipient-name" readonly>
		          </div>
		          <div class="form-group">
		            <label for="message-text" class="control-label">内容:</label>
		            <textarea class="form-control" id="message-text" rows="5"></textarea>
		          </div>
		        </form>
		      </div>
		      <div class="modal-footer">
		        <button id="btn-close" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button id="btn-submit" type="button" class="btn btn-primary">提交</button>
		      </div>
		    </div>
		  </div>
		</div>
		
        <!-- 评论 start -->
        <div class="comment panel panel-primary">
	        <div class="panel-heading">评论区</div>
	        <!-- foreach start -->
	        <div class="row" id="comment-container">
		        <c:forEach items="${commentExpandList }" var="commentExpand" >
		        <div class="comment-item">
				  	<!-- 第一层， 头像、id/name、点赞数 -->
				 	<div class="col-xs-12 col-sm-12 first-level">
				 		<div class="col-xs-1 head-img">
					 		<img class="img-responsive img-circle" alt="img" src="${commentExpand.userImg != null ?commentExpand.userImg : 'images/commons/default_headimg.png' }" >
				 		</div>
				 		<div class="col-xs-9 text-primary">${commentExpand.nickname != null ? commentExpand.nickname : '匿名用户' }</div>
				 		<div class="col-xs-2"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">${commentExpand.likeNum }</span></div>
				 	</div>
				  	<!-- 第二层 ， 内容-->
				 	<div class="col-xs-offset-1 col-xs-11 second-level">
				 		<p class="text-muted">${commentExpand.content }</p>
				 	</div>
				  	<!-- 第三层 ， 日期、回复(如果有显示条数)-->
				 	<div class="col-xs-offset-1 col-xs-11 third-level">
				 		<span class="text-muted time">${commentExpand.createTimeStr}</span>
				 		 <a href="#" class="text-primary col-xs-offset-1">回复${commentExpand.replyNum }</a>
				 	</div>
			  	</div>
		        </c:forEach>
	        </div>
	        
        </div>
        
	</div>
	<script type="text/javascript">
		function func_back(){
			history.back();
		}
		
		function func_forward(){
			history.forward();
		}
		function func_close(){
			window.opener=null;
		  	window.open('','_self');
		  	window.close();
		}
		
		function func_reload(){
			location.reload();
		}
		//jquery start
		$(function(){
			$('#commentModal').on('show.bs.modal', function (event) {
				  var button = $(event.relatedTarget) 
				  var recipient = button.data('whatever') 
				  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
				  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
				  var modal = $(this)
				  modal.find('.modal-title').text('对 ' + recipient + '进行评论')
				  modal.find('.modal-body input').val(recipient)
			});
			
			$("#btn-submit").click(function(e){
				  $.ajax({
						type:"POST",
						url:"comment/addPersonCommentAsync.do",
						data:{'topicId':"${request_user.id}", 'content':$("#message-text").val()},
						dataType:'json',
						async:true,
//					    crossDomain: true,
						beforeSend:function(){
							var content = $("#message-text").val();
							if($.trim(content) == ""){
								return false; 
							}
						},
						success:function(commentExpand){  //后端已经将数据转为json对象了....
							
							console.log(commentExpand);
							if(commentExpand.message != null){
								alert(commentExpand.message)
								return;
							}
							var str = '<div class="comment-item">'+
								'				 	<div class="col-xs-12 col-sm-12 first-level">'+
								'				 		<div class="col-xs-1 head-img">'+
								'					 		<img class="img-responsive img-circle" alt="img" src="'+commentExpand.userImg+'" >'+
								'				 		</div>'+
								'				 		<div class="col-xs-9 text-primary">'+commentExpand.nickname+'</div>'+
								'				 		<div class="col-xs-2"><span class="glyphicon glyphicon-thumbs-up" aria-hidden="true">'+commentExpand.likeNum +'</span></div>'+
								'				 	</div>'+
								'				 	<div class="col-xs-offset-1 col-xs-11 second-level">'+
								'				 		<p class="text-muted">'+commentExpand.content+'</p>'+
								'				 	</div>'+
								'				 	<div class="col-xs-offset-1 col-xs-11 third-level">'+
								'				 		<span class="text-muted time">'+commentExpand.createTimeStr+'</span>'+
								'				 		 <a href="#" class="text-primary col-xs-offset-1">回复'+commentExpand.replyNum+'</a>'+
								'				 	</div>'+
								'			  	</div>';
						    $("#comment-container").prepend(str);
						    $("#message-text").val("");
						    $("#commentModal").fadeOut(1000);
			            	setTimeout(function(){
			            		$("#btn-close").click();
			            		},1000);
						},
						error:function(xhr){
							  alert('error:' + JSON.stringify(xhr));
							  alert("发送失败");
						}
		            });
			});//  ajax  end
			
			$(".btn-go-user-info").click(function(){
				alert($(this).val())
				
			});//  btn-go-user-info click  event end
		}); //jqeuery end
		
		
	</script>
	
</body>
</html>