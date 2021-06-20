package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Service("orderDetailServiceMysql")
public class OrderDetailServiceMysqlImp implements IOrderService {

	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public void guardarOrder(Order order) {
		orderRepository.save(order);
		
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orders = (List<Order>) orderRepository.findAll();
		return orders;
	}

}
