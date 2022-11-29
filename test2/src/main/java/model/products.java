package model;
import javax.persistence.*;

@Entity
public class products  implements java.io.Serializable{
	@Id
	private Integer product_ID;
	private String product_catagory,product_Name,product_price,imagePath,product_describe;
	public products() {}
	public products(Integer product_ID, String product_catagory, String product_Name, String product_price,
		String imagePath, String product_describe) {
		this.product_ID = product_ID;
		this.product_catagory = product_catagory;
		this.product_Name = product_Name;
		this.product_price = product_price;
		this.imagePath = imagePath;
		this.product_describe = product_describe;
	}
	public Integer getProduct_ID() {
		return product_ID;
	}
	public void setProduct_ID(Integer product_ID) {
		this.product_ID = product_ID;
	}
	public String getProduct_catagory() {
		return product_catagory;
	}
	public void setProduct_catagory(String product_catagory) {
		this.product_catagory = product_catagory;
	}
	public String getProduct_Name() {
		return product_Name;
	}
	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}
	public String getProduct_price() {
		return product_price;
	}
	public void setProduct_price(String product_price) {
		this.product_price = product_price;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public String getProduct_describe() {
		return product_describe;
	}
	public void setProduct_describe(String product_describe) {
		this.product_describe = product_describe;
	}
	@Override
	public String toString() {
		return "product [product_ID=" + product_ID + ", product_catagory=" + product_catagory + ", product_Name="
				+ product_Name + ", product_price=" + product_price + ", imagePath=" + imagePath + ", product_describe="
				+ product_describe + "]";
	}
	

}
