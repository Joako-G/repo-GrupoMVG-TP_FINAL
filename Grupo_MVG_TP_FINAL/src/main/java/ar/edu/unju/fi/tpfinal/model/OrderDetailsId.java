package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class OrderDetailsId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="orderNumber")
	private Order order;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="productCode")
	private Product product;

	public OrderDetailsId() {
		super();
	}

	public OrderDetailsId(Order order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}

	public Order getOrderNumber() {
		return order;
	}

	public void setOrderNumber(Order order) {
		this.order = order;
	}

	public Product getProductCode() {
		return product;
	}

	public void setProductCode(Product product) {
		this.product = product;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderDetailsId [order=" + order + ", product=" + product + "]";
	}

}
