<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<HEAD>
<TITLE>用户登录</TITLE>
<link rel="stylesheet" href="<c:url value='/css/login.css'/>"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</HEAD>
<BODY id=userlogin_body>
	<DIV>
	 <marquee>
 <h1 style="font-size: 50px">易讯无限分销平台管理系统欢迎您</h1>
 </marquee>
	</DIV>

	<DIV id=user_login>
	<form action="<%=request.getContextPath()%>/login.htm" method="post">
		<DL>
			<DD id=user_top>
				<UL>
					<LI class=user_top_l></LI>
					<LI class=user_top_c></LI>
					<LI class=user_top_r></LI>
				</UL>
			<DD id=user_main>
				<UL>
					<LI class=user_main_l></LI>
					<LI class=user_main_c>
						<DIV class=user_main_box>
							<UL>
								<LI class=user_main_text>用户名：</LI>
								<LI class=user_main_input>
								<input class=TxtUserNameCssClass  maxLength=20  type="text" name="username"  id="username" value="${username}"/>
								</LI>
							</UL>
							<UL>
								<LI class=user_main_text>密 码：</LI>
								<LI class=user_main_input>
								<input class=TxtPasswordCssClass type="password" name="password"  id="password" value=""/>
							</UL>
							<UL>
								<LI class=user_main_text></LI>
								<LI class=user_main_input>
								  <label><font color="red">${msg}</font></label>
								</LI>
							</UL>
						</DIV>
					</LI>
					<LI class=user_main_r>
					 <input class="IbtnEnterCssClass" id="IbtnEnter" type="image" src="<%=request.getContextPath()%>/Images/user_botton.gif"/>
						</LI>
				</UL>
			<DD id=user_bottom>
				<UL>
					<LI class=user_bottom_l></LI>
					<LI class=user_bottom_c><SPAN style="MARGIN-TOP: 40px">
							&copy; hello
					</SPAN></LI>
					<LI class=user_bottom_r></LI>
				</UL>
			</DD>
		</DL>
		</form>
	</DIV>
	<SPAN id=ValrUserName style="DISPLAY: none; COLOR: red"></SPAN>
	<SPAN id=ValrPassword style="DISPLAY: none; COLOR: red"></SPAN>
	<SPAN id=ValrValidateCode style="DISPLAY: none; COLOR: red"></SPAN>
	<DIV id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></DIV>

	<DIV></DIV>

</BODY>
</HTML>