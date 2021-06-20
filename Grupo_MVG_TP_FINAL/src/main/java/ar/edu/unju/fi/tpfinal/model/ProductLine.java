package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PRODUCTLINES")
public class ProductLine {
	
	@Id
	@Column(name = "productLine", length = 50)
	private String id;
	
	@NotEmpty(message = "Falta descripcion")
	@Column(name = "textDescription", length = 4000)
	private String textDescripcion;
	
	@Column(name = "htmlDescription",columnDefinition = "MEDIUMTEXT")
	private String htmlDescripcion;
	
	@Lob
	@Column(name = "image", length=100000)
	private byte[] imagen;
	
	//Relacion con Product
	@OneToMany(mappedBy = "productLine")
	private List<Product> productos = new ArrayList<Product>();
	
	public ProductLine() {
		// TODO Auto-generated constructor stub
	}

	public ProductLine(String id, String textDescripcion, String htmlDescripcion, byte[] imagen) {
		super();
		this.id = id;
		this.textDescripcion = textDescripcion;
		this.htmlDescripcion = htmlDescripcion;
		this.imagen = imagen;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "ProductLine [id=" + id + ", textDescripcion=" + textDescripcion
				+ ", htmlDescripcion=" + htmlDescripcion + ", imagen=" + Arrays.toString(imagen) + "]";
	}

}
