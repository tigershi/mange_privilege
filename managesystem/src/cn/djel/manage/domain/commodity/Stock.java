package cn.djel.manage.domain.commodity;

import java.io.Serializable;

public class Stock implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8779259800840579908L;
	
	private Integer id;
	private Integer stockCount;
	private Integer realStockCount;
	private Integer lastStockCount;
	private Integer lastRealStockCount;
	private Integer state;
	private String comment;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStockCount() {
		return stockCount;
	}
	public void setStockCount(Integer stockCount) {
		this.stockCount = stockCount;
	}
	public Integer getRealStockCount() {
		return realStockCount;
	}
	public void setRealStockCount(Integer realStockCount) {
		this.realStockCount = realStockCount;
	}
	public Integer getLastStockCount() {
		return lastStockCount;
	}
	public void setLastStockCount(Integer lastStockCount) {
		this.lastStockCount = lastStockCount;
	}
	public Integer getLastRealStockCount() {
		return lastRealStockCount;
	}
	public void setLastRealStockCount(Integer lastRealStockCount) {
		this.lastRealStockCount = lastRealStockCount;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

}
