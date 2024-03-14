package app.dto;

import java.sql.Date;

public class SaleDto {
	private int idSale;
    private PetDto idPet;
    private PersonDto ownerDocument;
    private OrderDto idOrder;
    private String productName;
    private double price;
    private int amount;
    private Date date;
	public SaleDto() {
		this.date = new  Date(System.currentTimeMillis());
	}
	public int getIdSale() {
		return idSale;
	}
	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}
	public PetDto getIdPet() {
		return idPet;
	}
	public void setIdPet(PetDto idPet) {
		this.idPet = idPet;
	}
	public PersonDto getOwnerDocument() {
		return ownerDocument;
	}
	public void setOwnerDocument(PersonDto ownerDocument) {
		this.ownerDocument = ownerDocument;
	}
	public OrderDto getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(OrderDto idOrder) {
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
