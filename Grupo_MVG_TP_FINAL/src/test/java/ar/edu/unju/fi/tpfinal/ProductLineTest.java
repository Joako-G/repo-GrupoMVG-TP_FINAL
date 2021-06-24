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
		
		ProductLine lineaDeProductos2 = new ProductLine("Motorcycles", "Our motorcycles are state of the art replicas of classic as well as contemporary motorcycle legends such as Harley Davidson, Ducati and Vespa. Models contain stunning details such as official logos, rotating wheels, working kickstand, front suspension, gear-shift lever, footbrake lever, and drive chain. Materials used include diecast and plastic. The models range in size from 1:10 to 1:50 scale and include numerous limited edition and several out-of-production vehicles. All models come fully assembled and ready for display in the home or office. Most include a certificate of authenticity.", null, null);
		productLineService.guardarProductLine(lineaDeProductos2);
		
		ProductLine lineaDeProductos3 = new ProductLine("Planes", "Unique, diecast airplane and helicopter replicas suitable for collections, as well as home, office or classroom decorations. Models contain stunning details such as official logos and insignias, rotating jet engines and propellers, retractable wheels, and so on. Most come fully assembled and with a certificate of authenticity from their manufacturers.", null, null);
		productLineService.guardarProductLine(lineaDeProductos3);
		
		ProductLine lineaDeProductos4 = new ProductLine("Ships", "The perfect holiday or anniversary gift for executives, clients, friends, and family. These handcrafted model ships are unique, stunning works of art that will be treasured for generations! They come fully assembled and ready for display in the home or office. We guarantee the highest quality, and best value.", null, null);
		productLineService.guardarProductLine(lineaDeProductos4);
		
		ProductLine lineaDeProductos5 = new ProductLine("Trains", "Model trains are a rewarding hobby for enthusiasts of all ages. Whether you're looking for collectible wooden trains, electric streetcars or locomotives, you'll find a number of great choices for any budget within this category. The interactive aspect of trains makes toy trains perfect for young children. The wooden train sets are ideal for children under the age of 5.", null, null);
		productLineService.guardarProductLine(lineaDeProductos5);
		
		assertEquals("Classic Cars", lineaDeProductos1.getId());
	}

}
