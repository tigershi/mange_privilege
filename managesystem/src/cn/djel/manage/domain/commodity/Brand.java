package cn.djel.manage.domain.commodity;

import java.io.Serializable;

public class Brand implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -714846426421762194L;
	
	  private int id;
	 private String name;
	 private Integer level;
	 private Integer parentId;
	 private Integer status;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	

}
