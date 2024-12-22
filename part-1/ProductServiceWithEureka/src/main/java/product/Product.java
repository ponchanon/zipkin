package product;

public class Product {
	private String productNumber;
	private String name;
	private int stockCount;

	public Product(String productNumber, String name) {
		super();
		this.productNumber = productNumber;
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStockCount() {
		return stockCount;
	}

	public void setStockCount(int stockCount) {
		this.stockCount = stockCount;
	}


}
