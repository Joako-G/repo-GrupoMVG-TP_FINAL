package ar.edu.unju.fi.tpfinal.service;

import java.util.List;

import ar.edu.unju.fi.tpfinal.model.Order;

public interface IOrderService {

	void guardarOrder(Order order);
	public List<Order> getOrders();
}
