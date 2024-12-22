package stocks;

public class Stock {
	private String productNumber;
	private int count;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(String productNumber, int count) {
		super();
		this.productNumber = productNumber;
		this.count = count;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
