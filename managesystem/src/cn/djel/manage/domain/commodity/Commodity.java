package cn.djel.manage.domain.commodity;

import java.io.Serializable;

public class Commodity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2876249586788563219L;
	
	 private int id;
	 private String name;
	 private double price;
	 private double marketPrice;
	 private String manufacturer;
	 private Integer enable;
	 private Integer topTypeId;
	 private Integer typeId;
	 private Integer topBrandId;
	 private Integer brandId;
	 private Integer stockId;
	 private Integer topSupplierId;
	 private Integer supplierId;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(double marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public Integer getTopTypeId() {
		return topTypeId;
	}
	public void setTopTypeId(Integer topTypeId) {
		this.topTypeId = topTypeId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public Integer getTopBrandId() {
		return topBrandId;
	}
	public void setTopBrandId(Integer topBrandId) {
		this.topBrandId = topBrandId;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public Integer getStockId() {
		return stockId;
	}
	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
	public Integer getTopSupplierId() {
		return topSupplierId;
	}
	public void setTopSupplierId(Integer topSupplierId) {
		this.topSupplierId = topSupplierId;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	 
	

 
}
