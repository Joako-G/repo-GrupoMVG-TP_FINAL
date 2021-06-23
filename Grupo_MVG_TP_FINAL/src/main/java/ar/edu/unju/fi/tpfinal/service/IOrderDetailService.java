package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;

public interface IOrderDetailService {
	
	void guardarOrderDetail(OrderDetail orderDetail);
	public List<OrderDetail> getOrderDetails();
	public Optional<OrderDetail> getOrderDetailPorId(OrderDetailsId id);
	public void eliminarOrderDetail(OrderDetailsId id);
}
