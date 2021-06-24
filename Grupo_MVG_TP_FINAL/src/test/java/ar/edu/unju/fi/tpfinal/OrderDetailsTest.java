package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;
import ar.edu.unju.fi.tpfinal.model.Product;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;
import ar.edu.unju.fi.tpfinal.service.IOrderService;
import ar.edu.unju.fi.tpfinal.service.IProductService;

@SpringBootTest
class OrderDetailsTest {

	@Autowired
	IOrderDetailService orderDetailService;
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IProductService productService;
	
	@Test
	void testGuardarOrderDetail() {
		Optional<Order> ordenEncontrada = orderService.getOrderPorId(10103);
		System.out.println(ordenEncontrada.get().getId());
		
		Optional<Product> productEncontrado = productService.getProductPorId("S12_1108");
		System.out.println(productEncontrado);
		
		OrderDetailsId id = new OrderDetailsId(ordenEncontrada.get(), productEncontrado.get());
		OrderDetail orderDetail = new OrderDetail(id, 30, BigDecimal.valueOf(136.00), (short)3);
		orderDetailService.guardarOrderDetail(orderDetail);
		
		assertTrue(true);
	}

}
