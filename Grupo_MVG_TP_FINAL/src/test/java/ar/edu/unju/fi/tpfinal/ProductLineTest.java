package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;

@SpringBootTest
class ProductLineTest {

	@Autowired
	IProductLineService productLineService;
	
	@Test
	void testGuardarProductLine() {
		ProductLine lineaDeProductos1 = new ProductLine("Classic Cars", "Attention car enthusiasts: Make your wildest car ownership dreams come true. Whether you are looking for classic muscle cars, dream sports cars or movie-inspired miniatures, you will find great choices in this category. These replicas feature superb attention to detail and craftsmanship and offer features such as working steering system, opening forward compartment, opening rear trunk with removable spare wheel, 4-wheel independent spring suspension, and so on. The models range in size from 1:10 to 1:24 scale and include numerous limited edition and several out-of-production vehicles. All models include a certificate of authenticity from their manufacturers and come fully assembled and ready for display in the home or office.", null, null);
		productLineService.guardarProductLine(lineaDeProductos1);
		assertEquals("Classic Cars", lineaDeProductos1.getLineaDeProductos());
	}

}
