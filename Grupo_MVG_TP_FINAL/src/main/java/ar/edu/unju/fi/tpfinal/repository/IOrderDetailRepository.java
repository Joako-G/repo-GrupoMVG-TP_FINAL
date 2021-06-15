package ar.edu.unju.fi.tpfinal.repository;

import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.fi.tpfinal.model.OrderDetail;
import ar.edu.unju.fi.tpfinal.model.OrderDetailsId;

public interface IOrderDetailRepository extends CrudRepository <OrderDetail, OrderDetailsId>{

}
