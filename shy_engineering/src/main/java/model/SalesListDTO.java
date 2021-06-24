package model;

public class SalesListDTO {
	
	String prodNo;
	String prodName;
	String prodPrice;
	String sumQty;
	String sumPrice;
	
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getSumQty() {
		return sumQty;
	}
	public void setSumQty(String sumQty) {
		this.sumQty = sumQty;
	}
	public String getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}
}
