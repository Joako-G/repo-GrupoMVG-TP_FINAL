package ar.edu.unju.fi.tpfinal.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetail implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderDetailsId id;
	
	@NotNull
	@Min(value = 1, message = "La cantidad no puede ser menor a 1")
	@Column(name = "quantityOrdered")
	private int cantidad;
	
	@NotNull
	@Min(value = 0, message = "El precio no puede ser menor a 0")
	@Column(name = "priceEach")
	private double precio;
	
	@NotNull
	@Column(name = "orderLineNumber")
	private short numeroLinea;

	public OrderDetail() {
		super();
	}

	public OrderDetail(OrderDetailsId id,
			@NotNull @Min(value = 0, message = "La cantidad no puede ser menor a 0") int cantidad,
			@NotNull @Min(value = 0, message = "El precio no puede ser menor a 0") double precio,
			@NotNull short numeroLinea) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.numeroLinea = numeroLinea;
	}

	public OrderDetailsId getId() {
		return id;
	}

	public void setId(OrderDetailsId id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public short getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(short numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", numeroLinea="
				+ numeroLinea + "]";
	}

	


}