package com.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;

@Entity
public class Bill {
	@Id
	private long billNo;
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
	private Customer customers;
	
	@ManyToOne(targetEntity = Furniture.class, cascade = CascadeType.ALL)
	private Furniture furniture;
	
	@NotBlank(message = "Quantity should not be blank")
	private int quanity;
	
	@NotBlank(message = "Price should not be blank")
	@DecimalMin(value = "100.0", message = "Amount must be a number at least 100")
	private double price;
	
	@NotBlank(message = "Amount should not be blank")
	@DecimalMin(value = "100.0", message = "Amount must be a number at least 100")
	private double amount;

	public Bill(long billNo, Customer customers, Furniture furniture, int quanity, double price, double amount) {
		super();
		this.billNo = billNo;
		this.customers = customers;
		this.furniture = furniture;
		this.quanity = quanity;
		this.price = price;
		this.amount = amount;
	}

	public long getBillNo() {
		return billNo;
	}

	public void setBillNo(long billNo) {
		this.billNo = billNo;
	}

	public Customer getCustomers() {
		return customers;
	}

	public void setCustomers(Customer customers) {
		this.customers = customers;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public int getQuanity() {
		return quanity;
	}

	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Bill() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (billNo ^ (billNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		if (billNo != other.billNo)
			return false;
		return true;
	}


}
