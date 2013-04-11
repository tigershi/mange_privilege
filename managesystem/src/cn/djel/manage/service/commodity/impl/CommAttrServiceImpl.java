package cn.djel.manage.service.commodity.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.djel.manage.dao.commodity.ITypeDao;
import cn.djel.manage.domain.commodity.Type;
import cn.djel.manage.service.commodity.ICommAttrService;

@Service("commAttrService")
public class CommAttrServiceImpl implements ICommAttrService{
 private ITypeDao typeDao;
 @Resource(name="typeDao")
public void setTypeDao(ITypeDao typeDao) {
	this.typeDao = typeDao;
}

 public List<Type> getAllType(){
	return typeDao.getAllEntity();
 }

}
