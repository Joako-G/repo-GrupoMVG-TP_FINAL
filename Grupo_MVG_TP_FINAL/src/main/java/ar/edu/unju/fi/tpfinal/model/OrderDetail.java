package ar.edu.unju.fi.tpfinal.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="ORDERDETAILS")
public class OrderDetail {
	
	@Id
	@NotNull
	@Autowired
	@OneToOne(optional = false)
	@JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")
	private Order orden;
	
	@Id
	@NotNull
	@Autowired
	@OneToOne(optional = false)
	@JoinColumn(name = "productCode")
	private Product producto;
	
	@NotNull
	@Min(value = 0, message = "La cantidad no puede ser menor a 0")
	@Column(name = "quantityOrdered")
	private int cantidad;
	
	@NotNull
	@Min(value = 0, message = "El precio no puede ser menor a 0")
	@Column(name = "priceEach")
	private BigDecimal precio;
	
	@NotNull
	@Column(name = "orderLineNumber")
	private short numeroLinea;

	public OrderDetail() {
		super();
	}

	public OrderDetail(@NotNull Order orden, Product producto,
			@NotNull @Min(value = 0, message = "La cantidad no puede ser menor a 0") int cantidad,
			@NotNull @Min(value = 0, message = "El precio no puede ser menor a 0") BigDecimal precio,
			@NotNull short numeroLinea) {
		super();
		this.orden = orden;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.numeroLinea = numeroLinea;
	}


	public Order getOrden() {
		return orden;
	}

	public void setOrden(Order orden) {
		this.orden = orden;
	}


	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public short getNumeroLinea() {
		return numeroLinea;
	}

	public void setNumeroLinea(short numeroLinea) {
		this.numeroLinea = numeroLinea;
	}

	@Override
	public String toString() {
		return "OrderDetail [orden=" + orden + ", cantidad=" + cantidad + ", precio=" + precio + ", numeroLinea="
				+ numeroLinea + "]";
	}
	
	
}
