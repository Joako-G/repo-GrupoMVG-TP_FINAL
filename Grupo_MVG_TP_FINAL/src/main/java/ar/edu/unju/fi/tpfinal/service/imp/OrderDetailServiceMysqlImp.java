package ar.edu.unju.fi.tpfinal.service.imp;


import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

@Service("orderDetailServiceMysql")
public class OrderDetailServiceMysqlImp implements IOrderDetailService {
	
	private static final Log LOGGER = LogFactory.getLog(OrderDetailServiceMysqlImp.class);

	@Autowired
	private IOrderDetailRepository orderDetailRepository;

	@Override
	public void guardarOrderDetail(OrderDetail orderDetail) {
		orderDetailRepository.save(orderDetail);
		LOGGER.info("METHOD: guardarOrderDetail ---- Se agrego un objeto orderdatail en la lista: " + orderDetail);
	}

	@Override
	public List<OrderDetail> getOrderDetails() {
		List<OrderDetail> orderDetails = (List<OrderDetail>) orderDetailRepository.findAll();
		LOGGER.info("METHOD: getOrderDetails ---- Se buscó todos los objetos orderdetail de la lista");
		return orderDetails;
	}

	@Override
	public Optional<OrderDetail> getOrderDetailPorId(OrderDetailsId id) {
		Optional<OrderDetail> orderDetail = orderDetailRepository.findById(id);
		LOGGER.info("METHOD: getOrderDetailPorId ---- Se buscó un objeto order detail en la lista: " + orderDetail);
		return orderDetail;
	}

	@Override
	public void eliminarOrderDetail(OrderDetailsId id) {
		orderDetailRepository.deleteById(id);
		LOGGER.info("METHOD: eliminarOrderDetail ---- Se eliminó un objeto order detail de la lista: " + "id order: " + id.getOrder().getId() + " - id producto: " + id.getProduct().getId());
		
	}

}
