package cn.djel.manage.web.controller.commodity;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.djel.manage.domain.commodity.Type;
import cn.djel.manage.service.commodity.ICommAttrService;


@Controller
@RequestMapping("/comm_attr")
public class CommAttrController {
	private final static Logger log  = Logger.getLogger(CommAttrController.class);

private ICommAttrService commAttrService;
@Resource(name="commAttrService")
public void setCommAttrService(ICommAttrService commAttrService) {
	this.commAttrService = commAttrService;
}
//进入类型编辑页面
	@RequestMapping("/totype")	
public String toTypePage(){
		log.info("to type page");
	return "commodity/type/typeMain";
}

//进入类型添加页面
public String addTypePage(){
	log.info("to type add page");
	 return "commodity/type/typeMain";
}
@RequestMapping("/dotpsearch")
public @ResponseBody String doTypeSearch(@RequestParam(required=false)String searchName){
  List<Type> typeList = commAttrService.getAllType();
  String json =  JSON.toJSONString(typeList);
	log.info("do type search"+json);
 return json;	
}

}
