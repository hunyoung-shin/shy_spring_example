package model;

public class CartDTO {
	String membId;
	String prodNo;
	String catNum;
	String cartQty;
	String cartPrice;
	
	public String getMembId() {
		return membId;
	}
	public void setMembId(String membId) {
		this.membId = membId;
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo;
	}
	public String getCatNum() {
		return catNum;
	}
	public void setCatNum(String catNum) {
		this.catNum = catNum;
	}
	public String getCartQty() {
		return cartQty;
	}
	public void setCartQty(String cartQty) {
		this.cartQty = cartQty;
	}
	public String getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(String cartPrice) {
		this.cartPrice = cartPrice;
	}
	
	// prodOrderService에서 어쩔수 없이 넣은 것 -> 상관은 없다고 함
	String purchNo;
	public String getPurchNo() {
		return purchNo;
	}
	public void setPurchNo(String purchNo) {
		this.purchNo = purchNo;
	}
}
