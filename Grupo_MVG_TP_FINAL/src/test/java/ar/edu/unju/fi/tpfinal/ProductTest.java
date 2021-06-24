package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.model.ProductLine;
import ar.edu.unju.fi.tpfinal.service.IProductLineService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@SpringBootTest
class ProductTest {

	@Autowired
	@Qualifier("productServiceImpMysql")
	IProductService productService;
	
	@Autowired
	@Qualifier("productLineServiceMysql")
	IProductLineService productLineService;
	
	@Test
	void testGuaradrProduct() {
		Optional<ProductLine> lineaProductoEncontrada1 = productLineService.getProducLinePorId("Classic Cars");
		Optional<ProductLine> lineaProductoEncontrada2 = productLineService.getProducLinePorId("Motorcycles");
		
		Product product1 = new Product("S12_1108", "2001 Ferrari Enzo", "1:12", "Second Gear Diecast", "Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis." , 3619, 95.59, 207.80, lineaProductoEncontrada1.get());
		productService.guardarProduct(product1);
		
		Product product2 = new Product("S12_3891", "Ford Falcon", "1:10", "Second Gear Diecast", "Turnable front wheels; steering function; detailed interior; detailed engine; opening hood; opening trunk; opening doors; and detailed chassis.", 1049, 83.05, 173.02, lineaProductoEncontrada1.get());
		productService.guardarProduct(product2);
		
		Product product3 = new Product("S12_2823", "2002 Suzuki XREO", "1:12", "Unimax Art Galleries", "Official logos and insignias, saddle bags located on side of motorcycle, detailed engine, working steering, working suspension, two leather seats, luggage rack, dual exhaust pipes, small saddle bag located on handle bars, two-tone paint with chrome accents, superior die-cast detail , rotating wheels , working kick stand, diecast metal with plastic parts and baked enamel finish." , 9997, 66.27, 150.62, lineaProductoEncontrada2.get());
		productService.guardarProduct(product3);
		
		Product product4 = new Product("S24_2000", "1960 BSA Gold Star DBD34", "1:24", "Highway 66 Mini Classics", "Detailed scale replica with working suspension and constructed from over 70 parts" , 15, 37.32, 76.17, lineaProductoEncontrada2.get());
		productService.guardarProduct(product4);
		
		Product product5 = new Product("S24_2972", "1982 Lamborghini Diablo", "1:24", "Second Gear Diecast", "This replica features opening doors, superb detail and craftsmanship, working steering system, opening forward compartment, opening rear trunk with removable spare, 4 wheel independent spring suspension as well as factory baked enamel finish." , 7723, 16.24, 37.76, lineaProductoEncontrada1.get());
		productService.guardarProduct(product5);
		
		assertEquals("S12_1108",product1.getId());
	}

}