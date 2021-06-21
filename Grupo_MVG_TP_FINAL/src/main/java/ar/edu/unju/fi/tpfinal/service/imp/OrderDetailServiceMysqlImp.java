package ar.edu.unju.fi.tpfinal.service.imp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.repository.IOrderDetailRepository;
import ar.edu.unju.fi.tpfinal.service.IOrderDetailService;

@Service("orderDetailServiceMysql")
public class OrderDetailServiceMysqlImp implements IOrderDetailService {

	@Autowired
	private IOrderDetailRepository orderDetailRepository;

	@Override
	public void guardarOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

}
