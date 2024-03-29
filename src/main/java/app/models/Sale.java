package app.models;

import java.sql.Date;

public class Sale {
	private int idSale;
    private Pet idPet;
    private Person ownerDocument;
    private Order idOrder;
    private String productName;
    private double price;
    private int amount;
    private Date date;
	public int getIdSale() {
		return idSale;
	}
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public Pet getIdPet() {
		return idPet;
	}
	public void setIdPet(Pet idPet) {
		this.idPet = idPet;
	}
	public Person getOwnerDocument() {
		return ownerDocument;
	}
	public void setOwnerDocument(Person ownerDocument) {
		this.ownerDocument = ownerDocument;
	}
	public Order getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(Order idOrder) {
		this.idOrder = idOrder;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
