package demo.sbthymeleaf.model;

public class Customer {
	private String name;
	private String address;
	private int weight;
    public Customer() {}
	public Customer(String name, String address, int weight) {
		
		this.name = name;
		this.address = address;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
