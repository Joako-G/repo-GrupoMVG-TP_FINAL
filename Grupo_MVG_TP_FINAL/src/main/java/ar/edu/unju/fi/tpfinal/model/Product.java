package ar.edu.unju.fi.tpfinal.model;

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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
	@Column(name="productCode")
	private String id;
	
	@NotEmpty(message = "Debe ingresar nombre del producto")
	@Column(name="productName", length = 70)
	public String nombreProducto;
	
	@NotEmpty(message = "Ingresar escala")
	@Column(name="productScale")
	private String productScale;
	
	@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora del producto")
	@Column(name="productVendor", length = 50)
	private String vendedorProducto;
	
	@NotEmpty(message = "Debe ingresar la descripcion del producto")
	@Column(name="productDescription", columnDefinition="TEXT")
	private String descripcion;
	
	@Min(value = 0, message = "Debe ser igual o mayor a 0")
	@Column(name="quantityInStock")
	private int stock;
	
	@Min(value = 1, message = "Debe ser igual o mayor a 1")
	@Column(name="buyPrice")
	private double precioCompra;
	
	@Min(value = 1, message = "Debe ser igual o mayor a 1")
	@Column(name="MSRP")
	private double MSRP;
	
	//Relacion con ProductLine
	@ManyToOne
	@JoinColumn(name="productLine")
	private ProductLine productLine;
	
	//Relacion con OrderDetail
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "id.product")
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String id, @NotEmpty(message = "Debe ingresar nombre del producto") String nombreProducto,
			@NotNull String productScale,
			@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora del producto") String vendedorProducto,
			@NotEmpty(message = "Debe ingresar la descripcion del producto") String descripcion,
			@NotNull(message = "Debe ingresar stock del producto") int stock,
			@NotNull(message = "Debe ingresar el precio de compra") double precioCompra, double mSRP,
			ProductLine productLine) {

		super();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.productScale = productScale;
		this.vendedorProducto = vendedorProducto;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precioCompra = precioCompra;
		MSRP = mSRP;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getProductScale() {
		return productScale;
	}

	public void setProductScale(String productScale) {
		this.productScale = productScale;
	}

	public String getVendedorProducto() {
		return vendedorProducto;
	}

	public void setVendedorProducto(String vendedorProducto) {
		this.vendedorProducto = vendedorProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getMSRP() {
		return MSRP;
	}

	public void setMSRP(double mSRP) {
		MSRP = mSRP;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nombreProducto=" + nombreProducto + ", productScale=" + productScale
				+ ", vendedorProducto=" + vendedorProducto + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precioCompra=" + precioCompra + ", MSRP=" + MSRP + "]";
	}
	
}
