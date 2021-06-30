package ar.edu.unju.fi.tpfinal.service.imp;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.Customer;
import ar.edu.unju.fi.tpfinal.repository.ICustomerRepository;
import ar.edu.unju.fi.tpfinal.service.ICustomerService;


@Service("customerServiceImpMysql")
public class CustomerServiceMysqlImp implements ICustomerService{

	private static final Log LOGGER = LogFactory.getLog(CustomerServiceMysqlImp.class);

	@Autowired
	private Customer customer;
	
	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public void guardarCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer getCustomer() {
		return customer;
	}

	@Override
	public Optional<Customer> getCustomerPorId(Long idCliente) {
		Optional <Customer> customer = customerRepository.findById(idCliente);
		return customer;
	}

	@Override
	public void elimarCustomer(Long idCliente) {
		customerRepository.deleteById(idCliente);
		
	}

	@Override
	public boolean existCustomerPorEmpleado(Integer employeeId) {
		LOGGER.info("METHOD: existCustomerPorEmpleado ---- Se consultó si un empleado existe en la tabla de clientes. Id del empleado: " + employeeId);
		boolean band = false;
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		for (int i=0;i<customers.size();i++) {
			Customer elementoLista = customers.get(i);
			if (elementoLista.getEmpleado().getId().compareTo(employeeId) == 0) {
				band = true;	
				}
		}
		return band;
	}

}
