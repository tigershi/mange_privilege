package cn.djel.manage.domain.user;

import java.io.Serializable;

public class Right implements Serializable{

	/**
	 * 
	 */
private static final long serialVersionUID = -4899819849571225628L;
	/**
	 *  the right entity
	 */

   private int id;
   private String name;
   private String url;
   private Integer enable;
   private int rightBit;
   private long rightCode;
   private String comment;
   
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
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Integer getEnable() {
	return enable;
}
public void setEnable(Integer enable) {
	this.enable = enable;
}
public int getRightBit() {
	return rightBit;
}
public void setRightBit(int rightBit) {
	this.rightBit = rightBit;
}
public long getRightCode() {
	return rightCode;
}
public void setRightCode(long rightCode) {
	this.rightCode = rightCode;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
}
