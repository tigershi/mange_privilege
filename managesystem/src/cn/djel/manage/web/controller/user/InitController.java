package cn.djel.manage.web.controller.user;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;


import cn.djel.manage.domain.user.Right;
import cn.djel.manage.domain.user.TreeNode;
import cn.djel.manage.domain.user.User;
import cn.djel.manage.service.user.IInitService;
import cn.djel.manage.utils.InitConstant;
import cn.djel.manage.utils.InitUtil;

@Controller
@RequestMapping("/init")
public class InitController {
private final Logger log  = Logger.getLogger(InitController.class);
 private IInitService initService;
 @Resource(name="initService")
 public void setInitService(IInitService initService) {
	 this.initService = initService;
 }
 
 @RequestMapping("/navigate")
 public String initMenu(HttpServletRequest request){
	log.info("开始初始化");
   List<TreeNode>rootnodes = initService.getTreesByParent("0");
   User currentUser = (User) request.getSession().getAttribute(InitConstant.LOGINUSER);
   @SuppressWarnings("unchecked")
   Map<String,Right> rightmap = (Map<String, Right>) request.getSession().getServletContext().getAttribute(InitConstant.RIGHTMAP);
	for(TreeNode rootnode:rootnodes){
		List<TreeNode> children = initService.getTreesByParent(rootnode.getId());
		if(currentUser.isAdmin()){
			rootnode.setChildren(children);
		}else{
		 for(TreeNode childnode:children){
			if(judgeTree(childnode,currentUser,rightmap)){
				rootnode.addChild(childnode);
			}
		 }
		}
		if(rootnode.getChildren() ==null){
			rootnodes.remove(rootnode);
		}
	}
	          
	String json = JSON.toJSONString(rootnodes);
	log.info("---生成intitjson——————————————————————————");
	log.info(json);
	log.info("开始初始化完成");
	return json;
 }
 @RequestMapping("/login/topage")
 public String tologin(){
	 log.info("to login page");
	return "comm/login";
 }
 @RequestMapping("/login/done")
 public String dologin(String userword, String password){
	return password;
 }
 private boolean judgeTree(TreeNode node,User user,Map<String,Right> rightMap){
	 String url = node.getUrl();
	 boolean flag = false;
	 if(url !=null && !url.equals("")){
	
		 if(user.isAdmin()){
			 flag =true;
		 }else{
			Right ri = rightMap.get(node.getUrl());
			return InitUtil.judgeRight(user,ri);
		 }
	 }
	return flag;
 }

}
