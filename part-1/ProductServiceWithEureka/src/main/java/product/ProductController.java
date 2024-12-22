package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductController {
	@Autowired
	StockFeignClient stockClient;

	@RequestMapping("/product/{productNumber}")
	public Product getProductDetail(@PathVariable("productNumber") String productNumber) {
		Product product = new Product(productNumber, "samsung galaxy");
		product.setStockCount(stockClient.getStockCount(productNumber));
		return product;
	}

	@FeignClient(name = "StockService")
	interface StockFeignClient {
		@RequestMapping("/stock/{productNumber}")
		public int getStockCount(@PathVariable("productNumber") String productNumber);
	}

}
