package model;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		productDAO A=null;
		A=new productDAO();
		products s=new products(1,"2","1","1","1","1");
		A.updateProduct(s);	
		System.out.println(s);
	}

}
