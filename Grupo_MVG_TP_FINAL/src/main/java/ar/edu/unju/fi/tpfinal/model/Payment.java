package ar.edu.unju.fi.tpfinal.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PAYMENTS")
public class Payment {
	
	@Id
	@NotNull
	@OneToOne(optional = false)
	@JoinColumn(name = "customerNumber", referencedColumnName = "customerNumber")
	private Customer customer;
	
	@Id
	@NotNull
	@Column(name = "checknumber", length = 50)
	private String checkNumber;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "paymentDate")
	private LocalDate fechaPago;
	
	@NotNull
	@Min(value = 0, message = "La cantidad no puede ser menor a 0")
	@Column(name = "amount")
	private BigDecimal cantidad;

	public Payment() {
		super();
	}

	public Payment(Customer customer, @NotNull String checkNumber, LocalDate fechaPago,
			@NotNull @Min(value = 0, message = "La cantidad no puede ser menor a 0") BigDecimal cantidad) {
		super();
		this.customer = customer;
		this.checkNumber = checkNumber;
		this.fechaPago = fechaPago;
		this.cantidad = cantidad;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCheckNumber() {
		return checkNumber;
	}

	public void setCheckNumber(String checkNumber) {
		this.checkNumber = checkNumber;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Payment [checkNumber=" + checkNumber + ", cantidad=" + cantidad + "]";
	}
	
	
}
