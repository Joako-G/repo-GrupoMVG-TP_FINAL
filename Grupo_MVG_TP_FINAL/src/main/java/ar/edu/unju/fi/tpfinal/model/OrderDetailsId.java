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
	private Order orderNumber;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="productCode")
	private Product productCode;

	public OrderDetailsId() {
		super();
	}

	public OrderDetailsId(Order orderNumber, Product productCode) {
		super();
		this.orderNumber = orderNumber;
		this.productCode = productCode;
	}

	public Order getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Order orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Product getProductCode() {
		return productCode;
	}

	public void setProductCode(Product productCode) {
		this.productCode = productCode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderDetailsId [orderNumber=" + orderNumber + ", productCode=" + productCode + "]";
	}

}
