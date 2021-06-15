package ar.edu.unju.fi.tpfinal.model;

import java.sql.Clob;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@NotNull(message = "Debe elegir un id valido")
	@Column(name = "orderNumber")
	private int id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debe elegir una fecha valida")
	@Column(name = "orderDate")
	private LocalDate fechaOrden;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debe elegir una fecha valida")
	@Column(name = "requiredDate")
	private LocalDate fechaRequerida;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debe elegir una fecha valida")
	@Column(name = "shippedDate")
	private LocalDate fechaEnvio;
	
	@NotNull(message = "Debe ingresar el estado")
	@Column(name = "status", length = 15)
	private String estado;
	
	@Column(name = "comments")
	private Clob comentarios;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerNumber")
	private Customer customerNumber;
	
	@OneToMany(mappedBy = "id")
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	public Order() {
		super();
	}

	public Order(@NotNull(message = "Debe elegir un id valido") int id,
			@NotNull(message = "Debe elegir una fecha valida") LocalDate fechaOrden,
			@NotNull(message = "Debe elegir una fecha valida") LocalDate fechaRequerida,
			@NotNull(message = "Debe elegir una fecha valida") LocalDate fechaEnvio,
			@NotNull(message = "Debe ingresar el estado") String estado, Clob comentarios, Customer customerNumber,
			List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.fechaOrden = fechaOrden;
		this.fechaRequerida = fechaRequerida;
		this.fechaEnvio = fechaEnvio;
		this.estado = estado;
		this.comentarios = comentarios;
		this.customerNumber = customerNumber;
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFechaOrden() {
		return fechaOrden;
	}

	public void setFechaOrden(LocalDate fechaOrden) {
		this.fechaOrden = fechaOrden;
	}

	public LocalDate getFechaRequerida() {
		return fechaRequerida;
	}

	public void setFechaRequerida(LocalDate fechaRequerida) {
		this.fechaRequerida = fechaRequerida;
	}

	public LocalDate getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(LocalDate fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Clob getComentarios() {
		return comentarios;
	}

	public void setComentarios(Clob comentarios) {
		this.comentarios = comentarios;
	}

	public Customer getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Customer customerNumber) {
		this.customerNumber = customerNumber;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", fechaOrden=" + fechaOrden + ", fechaRequerida=" + fechaRequerida + ", fechaEnvio="
				+ fechaEnvio + ", estado=" + estado + ", comentarios=" + comentarios + ", customerNumber="
				+ customerNumber + ", orderDetails=" + orderDetails + "]";
	}

	
	
}
