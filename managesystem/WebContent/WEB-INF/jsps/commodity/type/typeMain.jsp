<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
<script type="text/javascript">
function typeSearch(){
	alert("typesearch");
 var searchName = $('#searchname').val();
 var typeUrl = path +"comm_attr/dotpsearch.do?"
 /*  $.ajax({
	   type:"post",
	   url:typeUrl
 }).done(function(msg){
	   alert(msg);
	 	     
	});  */
 
 $('#type_list').datagrid({ url:typeUrl,queryParams:{"searchName":searchName},method:"post"});
 
		/*  var query={searchName:searchName}; //把查询条件拼接成JSON
		 $("#type_list").datagrid('options').queryParams=query;//把查询条件赋值给datagrid内部变量
		 $("#type_list").datagrid('options').url=typeUrl;
		 $("#type_list").datagrid('options').method="post"; */
		 $("#type_list").datagrid('reload');
		 alert("typesearch");
}
function typeAdd(){
         $('#type_list').datagrid('appendRow',{isNewRecord:true});  
         var index = $('#type_list').datagrid('getRows').length - 1;  
         $('#type_list').datagrid('expandRow', index);  
         $('#type_list').datagrid('selectRow', index);  
    
}
function typeEdit(){
	
}
function typeDel(){
	
}
</script>
<div id="toolbar">  
       <div id="search" style="padding:3px">  
         <span>类型名:</span>  
          <input id="searchname" style="line-height:26px;border:1px solid #ccc">  
       <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="typeSearch()">查询</a>  
      </div> 
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="typeAdd()">添加</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="typeEdit()">编辑</a>  
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="typeDel()">删除</a>  
 </div>  
 <table id="type_list" class="easyui-datagrid" style="width:auto;height:700px"  
        url="" toolbar="#toolbar"  
        title="商品类型编辑管理"
        rownumbers="true" pagination="true">  
    <thead>  
        <tr>  
            <th field="id" width="80">类型id</th>  
            <th field="name" width="80">类型名称</th>  
            <th field="level" width="80" align="right">类型级别</th>  
            <th field="status" width="80" align="center">状态</th>  
            <th field="parentId" width="80" align="center">父类型id</th>  
        </tr>  
    </thead>  
</table>  
</div>

