package ar.edu.unju.fi.tpfinal.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PAYMENTS")
public class Payment {
	
	@EmbeddedId
	private PaymentId id;
	
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
	
	public Payment(PaymentId id, @NotNull LocalDate fechaPago,
			@NotNull @Min(value = 0, message = "La cantidad no puede ser menor a 0") BigDecimal cantidad) {
		super();
		this.id = id;
		this.fechaPago = fechaPago;
		this.cantidad = cantidad;
	}

	public PaymentId getId() {
		return id;
	}

	public void setId(PaymentId id) {
		this.id = id;
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
		return "Payment [id=" + id + ", fechaPago=" + fechaPago + ", cantidad=" + cantidad + "]";
	}
	
}