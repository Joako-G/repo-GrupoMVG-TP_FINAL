package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTLINES")
public class ProductLine {
	
	@Id
	@Column(name = "productLine")
	private String lineaDeProductos;
	
	@Column(name = "textDescription")
	private String textDescripcion;
	
	@Column(name = "htmlDescription")
	private String htmlDescripcion;
	
	@Column(name = "image")
	private byte[] imagen;
	
	@OneToMany(mappedBy = "productLine",cascade = CascadeType.ALL)
	private List<Product> productos = new ArrayList<Product>();
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	public ProductLine(String lineaDeProductos, String textDescripcion, String htmlDescripcion, byte[] imagen,
			List<Product> productos) {
		super();
		this.lineaDeProductos = lineaDeProductos;
		this.textDescripcion = textDescripcion;
		this.htmlDescripcion = htmlDescripcion;
		this.imagen = imagen;
		this.productos = productos;
	}

	public String getLineaDeProductos() {
		return lineaDeProductos;
	}

	public void setLineaDeProductos(String lineaDeProductos) {
		this.lineaDeProductos = lineaDeProductos;
	}

	public String getTextDescripcion() {
		return textDescripcion;
	}

	public void setTextDescripcion(String textDescripcion) {
		this.textDescripcion = textDescripcion;
	}

	public String getHtmlDescripcion() {
		return htmlDescripcion;
	}

	public void setHtmlDescripcion(String htmlDescripcion) {
		this.htmlDescripcion = htmlDescripcion;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public List<Product> getProductos() {
		return productos;
	}

	public void setProductos(List<Product> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "ProductLine [lineaDeProductos=" + lineaDeProductos + ", textDescripcion=" + textDescripcion
				+ ", htmlDescripcion=" + htmlDescripcion + ", imagen=" + Arrays.toString(imagen) + "]";
	}

}
