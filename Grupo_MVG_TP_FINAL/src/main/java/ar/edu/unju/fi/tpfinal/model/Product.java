package ar.edu.unju.fi.tpfinal.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="PRODUCTS")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="productCode")
	private long id;
	
	@NotEmpty(message = "Debe ingresar nombre del producto")
	@Column(name="productName", length = 20)
	private String nombreProducto;
	
	@NotNull
	@Column(name="productSacle")
	private LocalDate productScale;
	
	@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora del producto")
	@Column(name="productVendor", length = 30)
	private String vendedorProducto;
	
	@NotEmpty(message = "Debe ingresar la descripcion del producto")
	@Column(name="productDescription", length = 100)
	private String descripcion;
	
	@NotNull(message = "Debe ingresar stock del producto")
	@Column(name="quantityInStock")
	private int stock;
	
	@NotNull(message = "Debe ingresar el precio de compra")
	@Column(name="buyPrice")
	private float precioCompra;
	
	@Column(name="MSRP")
	private float MSRP;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productLine")
	private ProductLine productLine;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long id, @NotEmpty(message = "Debe ingresar nombre del producto") String nombreProducto,
			@NotNull LocalDate productScale,
			@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora del producto") String vendedorProducto,
			@NotEmpty(message = "Debe ingresar la descripcion del producto") String descripcion,
			@NotNull(message = "Debe ingresar stock del producto") int stock,
			@NotNull(message = "Debe ingresar el precio de compra") float precioCompra, float mSRP,
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
		this.productLine = productLine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public LocalDate getProductScale() {
		return productScale;
	}

	public void setProductScale(LocalDate productScale) {
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

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public float getMSRP() {
		return MSRP;
	}

	public void setMSRP(float mSRP) {
		MSRP = mSRP;
	}

	public ProductLine getProductLine() {
		return productLine;
	}

	public void setProductLine(ProductLine productLine) {
		this.productLine = productLine;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nombreProducto=" + nombreProducto + ", productScale=" + productScale
				+ ", vendedorProducto=" + vendedorProducto + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precioCompra=" + precioCompra + ", MSRP=" + MSRP + ", productLine=" + productLine + "]";
	}
	
}
