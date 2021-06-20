package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Order;
import ar.edu.unju.fi.tpfinal.repository.IOrderRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderService;

@Service("orderServiceMysql")
public class OrderServiceMysqlImp implements IOrderService {
	
	private static final Log LOGGER = LogFactory.getLog(OrderServiceMysqlImp.class);

	@Autowired
	private IOrderRepository orderRepository;
	
	@Override
	public void guardarOrder(Order order) {
		orderRepository.save(order);
		LOGGER.info("METHOD: guardarOrder ---- Se agrego un objeto order en la lista: " + order);

	}

	@Override
	public List<Order> getOrders() {
		LOGGER.info("METHOD: getOrders ---- Se consultó la tabla de ordenes");
		List<Order> orders = (List<Order>) orderRepository.findAll();
		return orders;
	}

}
