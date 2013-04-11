package cn.djel.manage.domain.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Role implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 705644480253768569L;
	
   private int id;
   private String name;
   private Integer enable;
   private String  roleValue;
   private String comment;
   private Set<Right> rights =null;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Integer getEnable() {
	return enable;
}
public void setEnable(Integer enable) {
	this.enable = enable;
}
public Set<Right> getRights() {
	return rights;
}
public void setRights(Set<Right> rs) {
	if(rights ==null){
		rights = new HashSet<Right>();
	}
	this.rights.addAll(rs);
}
public void addRight(Right right){
	if(rights ==null){
		rights = new HashSet<Right>();
	}
	rights.add(right);
}
public String getRoleValue() {
	return roleValue;
}
public void setRoleValue(String roleValue) {
	this.roleValue = roleValue;
}
	
}
