<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <c:url value="/" var="path"></c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>运营test系统</title>
    <link rel="stylesheet" type="text/css" href="${path}/css/themes/default/easyui.css">  
    <link rel="stylesheet" type="text/css" href="${path}/css/themes/icon.css"> 
    <script type="text/javascript" src="${path}/js/jquery-1.8.0.js"></script>  
    <script type="text/javascript" src="${path}/js/jquery.easyui.min.js"></script>  
    <script type="text/javascript">
    var path ="${path}";
    </script>
</head>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#navtree').tree({  
	    url : path+"menu/init.do",
	    onClick : function(node){
	    	if(node.attributes.url != ""){
	    	    alert(node.attributes.url);
	    		addTab(node.text,node.attributes.url);
	    	}
	    } 
	}   );
});

function addTab(title, url){
    if ($('#tt').tabs('exists', title)){  
        $('#tt').tabs('select', title);  
    } else {  
    	var content ="";
    	if(url != ""){
    	 $.ajax({
    	     type:"post",
    	     url:url 
    	 } ).done(function(data){
    		 content =data;
    	 });
    	 
    	$('#tt').tabs('add',{
    		 title:title,  
    	    content:content,  
    	    closable:true,  
    	});	
    	}
    }
 }
</script>
<body  class="easyui-layout" >
 
        <div id="north" data-options="region:'north'" style="background:#fafafa;color:#2d5593;height:60px;">
         <div style="font-size:20px;font-weight:bold;width:400px;padding:10px 0 0 10px;">运营test系统</div>  
       </div>
         
        <div id="west" data-options="region:'west',split:true" title="导航栏" style="width:200px;">
         <ul id="navtree" class="easyui-tree" >  
         </ul>  
        </div>  
        <div id="tt" data-options="region:'center'" class="easyui-tabs">
         
             <div title="Home">
              <marquee><h2>欢迎XX使用运营系统</h2></marquee> 
             </div>  
        </div>  


</body>
</html>