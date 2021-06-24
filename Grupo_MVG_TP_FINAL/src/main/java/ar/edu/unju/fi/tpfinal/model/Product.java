package ar.edu.unju.fi.tpfinal.model;

import java.sql.Clob;
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
	
	@NotNull
	@Column(name="productScale")
	private String productScale;
	
	@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora del producto")
	@Column(name="productVendor", length = 50)
	private String vendedorProducto;
	
	@NotEmpty(message = "Debe ingresar la descripcion del producto")
	@Column(name="productDescription")
	private Clob descripcion;
	
	@NotNull(message = "Debe ingresar stock del producto")
	@Column(name="quantityInStock")
	private int stock;
	
	@NotNull(message = "Debe ingresar el precio de compra")
	@Column(name="buyPrice")
	private float precioCompra;
	
	@Column(name="MSRP")
	private float MSRP;
	
	//Relacion con ProductLine
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="productLine")
	private ProductLine productLine;
	
	//Relacion con OrderDetail
	@OneToMany(mappedBy = "id.product")
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String id, @NotEmpty(message = "Debe ingresar nombre del producto") String nombreProducto,
			@NotNull String productScale,
			@NotEmpty(message = "Debe ingresar nombre de la empresa vendedora del producto") String vendedorProducto,
			@NotEmpty(message = "Debe ingresar la descripcion del producto") Clob descripcion,
			@NotNull(message = "Debe ingresar stock del producto") int stock,
			@NotNull(message = "Debe ingresar el precio de compra") float precioCompra, float mSRP) {
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

	public Clob getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(Clob descripcion) {
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
				+ ", precioCompra=" + precioCompra + ", MSRP=" + MSRP + "]";
	}
	
}
