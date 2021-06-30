package ar.edu.unju.fi.tpfinal.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinal.model.Customer;

public interface ICustomerService {
	
	public void guardarCustomer(Customer customer);
	public List<Customer> getCustomers();
	public Customer getCustomer();
	public Optional<Customer> getCustomerPorId(Long idCliente);
	public boolean existCustomerPorEmpleado(Integer employeeId);
	public void elimarCustomer(Long idCliente);
}
