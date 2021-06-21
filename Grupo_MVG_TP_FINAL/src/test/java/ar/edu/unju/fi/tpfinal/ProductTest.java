package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@SpringBootTest
class ProductTest {

	@Autowired
	@Qualifier("productServiceImpMysql")
	private IProductService productService;
	
	@Test
	void test() {
		//Product product1 = new Product("AA-123", "Televisor", null, "Perez Ibarra", "Smart TV 55'", 21, 24399, 0, null);
		//productService.guardarProduct(product1);
		//assertEquals("AA-123",product1.getId());
	}

}