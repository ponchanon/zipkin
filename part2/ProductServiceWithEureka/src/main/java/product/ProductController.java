package product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;


@RestController
public class ProductController {
	@Autowired
	StockFeignClient stockClient;
	@Autowired
	private CircuitBreakerFactory circuitBreakerFactory;

	@RequestMapping("/product/{productNumber}")

	public Product getProductDetail(@PathVariable("productNumber") String productNumber) {
		CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");

		Product product = new Product(productNumber, "samsung galaxy");
		Serializable count = circuitBreaker.run(() -> stockClient.getStockCount(productNumber), throwable -> getFallbackMethod());
		product.setStockCount((Integer) count);
		return product;
	}

	private int getFallbackMethod(){
		return -1;
	}

	@FeignClient(name = "StockService")
	interface StockFeignClient {
		@RequestMapping("/stock/{productNumber}")
		public int getStockCount(@PathVariable("productNumber") String productNumber);
	}

}
