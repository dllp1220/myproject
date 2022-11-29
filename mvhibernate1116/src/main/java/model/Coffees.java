package model;

public class Coffees implements java.io.Serializable {
	private String cofName;
	private Suppliers suppliers;
	private double price;
	private int sales;
	private int total;

	public Coffees() {
	}
public Coffees(String cofName, Suppliers suppliers, double price, int sales, int total) {
		this.cofName = cofName;
		this.suppliers = suppliers;
		this.price = price;
		this.sales = sales;
		this.total = total;
	}
	public String getCofName() {
		return this.cofName;
	}
	public void setCofName(String cofName) {
		this.cofName = cofName;
	}
	public Suppliers getSuppliers() {
		return this.suppliers;
	}
	public void setSuppliers(Suppliers suppliers) {
		this.suppliers = suppliers;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSales() {
		return this.sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getTotal() {
		return this.total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

}

