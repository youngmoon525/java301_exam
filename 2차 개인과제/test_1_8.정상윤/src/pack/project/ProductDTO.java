package pack.project;

public class ProductDTO {
	private String product_name, product_brand ;
	private int num, product_qty,product_cost;
	public ProductDTO() {}
	public ProductDTO(int num, String product_name, int product_qty, String product_brand, int product_cost) {
		super();
		this.num = num;
		this.product_name = product_name;
		this.product_qty = product_qty;
		this.product_brand = product_brand;
		this.product_cost = product_cost;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_brand() {
		return product_brand;
	}
	public void setProduct_brand(String product_brand) {
		this.product_brand = product_brand;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}
	public int getProduct_cost() {
		return product_cost;
	}
	public void setProduct_cost(int product_cost) {
		this.product_cost = product_cost;
	}
	
	
	
	
}
