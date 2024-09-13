package com.shinnosuke.infra.product;

import java.util.Date;

public class ProductDto {

	private String prseq;
	private String prProdName;
	private Integer UseNY;
	private String prProdDesc;
	private String prReguPrice;
	private String prSalePrice;
	private Integer prInventory;
	private Date prReDate;
	private Date prMoDate;
	private Integer prDelNY;
	//------------------------------
	public String getPrseq() {
		return prseq;
	}
	public void setPrseq(String prseq) {
		this.prseq = prseq;
	}
	public String getPrProdName() {
		return prProdName;
	}
	public void setPrProdName(String prProdName) {
		this.prProdName = prProdName;
	}
	public Integer getUseNY() {
		return UseNY;
	}
	public void setUseNY(Integer useNY) {
		UseNY = useNY;
	}
	public String getPrProdDesc() {
		return prProdDesc;
	}
	public void setPrProdDesc(String prProdDesc) {
		this.prProdDesc = prProdDesc;
	}
	public String getPrReguPrice() {
		return prReguPrice;
	}
	public void setPrReguPrice(String prReguPrice) {
		this.prReguPrice = prReguPrice;
	}
	public String getPrSalePrice() {
		return prSalePrice;
	}
	public void setPrSalePrice(String prSalePrice) {
		this.prSalePrice = prSalePrice;
	}
	public Integer getPrInventory() {
		return prInventory;
	}
	public void setPrInventory(Integer prInventory) {
		this.prInventory = prInventory;
	}
	public Date getPrReDate() {
		return prReDate;
	}
	public void setPrReDate(Date prReDate) {
		this.prReDate = prReDate;
	}
	public Date getPrMoDate() {
		return prMoDate;
	}
	public void setPrMoDate(Date prMoDate) {
		this.prMoDate = prMoDate;
	}
	public Integer getPrDelNY() {
		return prDelNY;
	}
	public void setPrDelNY(Integer prDelNY) {
		this.prDelNY = prDelNY;
	}
	
}
