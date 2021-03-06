package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERS")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderNumber")
	private Integer id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debe elegir una fecha válida")
	@Column(name = "orderDate")
	private LocalDate fechaOrden;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Debe elegir una fecha válida")
	@Column(name = "requiredDate")
	private LocalDate fechaRequerida;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "shippedDate")
	private LocalDate fechaEnvio;
	
	@NotEmpty(message = "Debe ingresar el estado")
	@Column(name = "status", length = 15)
	private String estado;
	
	@Column(name = "comments")
	private String comentarios;
	
	//Relacion con Customer
	@Autowired
	@NotNull(message = "Debe ingresar un cliente valido")
	@ManyToOne
	@JoinColumn(name = "customerNumber")
	public Customer customer;
	
	//Relacion con OrderDetail
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id.order")
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	public Order() {
		super();
	}

	public Order(@NotNull(message = "Debe elegir un ID válido") Integer id,
			@NotNull(message = "Debe elegir una fecha válida") LocalDate fechaOrden,
			@NotNull(message = "Debe elegir una fecha válida") LocalDate fechaRequerida, LocalDate fechaEnvio,
			@NotEmpty(message = "Debe ingresar el estado") String estado, String comentarios,
			@NotNull(message = "Debe ingresar un cliente valido") Customer customer) {
		super();
		this.id = id;
		this.fechaOrden = fechaOrden;
		this.fechaRequerida = fechaRequerida;
		this.fechaEnvio = fechaEnvio;
		this.estado = estado;
		this.comentarios = comentarios;
		this.customer = customer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
				+ fechaEnvio + ", estado=" + estado + ", comentarios=" + comentarios + ", customer=" + customer + "]";
	}
	
	
}
