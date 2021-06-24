package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderService {

	void guardarOrder(Order order);
	public List<Order> getOrders();
	public Optional<Order> getOrderPorId(Integer id);
	public void eliminarOrder(int id);
}
