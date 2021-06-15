package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class PaymentId implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="customerNumber")
	private Customer customerNumber;
	
	@NotNull
	@Column(name="checkNumber")
	private String numeroCheque;

	public PaymentId() {
		super();
	}

	public PaymentId(@NotNull Customer customerNumber, @NotNull String numeroCheque) {
		super();
		this.customerNumber = customerNumber;
		this.numeroCheque = numeroCheque;
	}

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PaymentId [customerNumber=" + customerNumber + ", numeroCheque=" + numeroCheque + "]";
	}
	
	
}
