package ar.edu.unju.fi.tpfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;


@SpringBootTest
class OrderDetailTest {

		@Autowired
		@Qualifier("orderDetailServiceMysql")
		private IOrderDetailService orderDetailService;
		
		@Test
		void test() {
			List <OrderDetail> od1 = orderDetailService.getOrderDetails();
			System.out.println(od1);
		}

}