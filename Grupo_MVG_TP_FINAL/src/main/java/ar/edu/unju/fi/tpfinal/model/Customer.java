package ar.edu.unju.fi.tpfinal.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerNumber")
	private Long idCliente;
	
	@NotEmpty(message = "Debe ingresar nombre de la empresa/negocio")
	@Column(name="customerName", length = 50)
	private int empresaNombre;
	
	@NotEmpty(message = "Debe ingresar apellido del cliente")
	@Column(name="contactLastName", length = 15)
	private String apellido;
	
	@NotEmpty(message = "Debe ingresar nombre del cliente")
	@Column(name="contactFirsName", length = 20)
	private String nombre;
	
	@Min(value=1000000, message = "El numero de telefono debe ser mayor a 1000000")
	@Max(value=999999999, message = "El numero de telefono no debe pasar los 999999999")
	@Column(name="phone")
	private int telefono;
	
	@NotEmpty(message = "Debe ingresar la direccion")
	@Column(name="addressLine1",length = 50)
	private String direccion1;
	
	@Column(name="addressLine2")
	private String direccion2;
	
	@NotEmpty(message = "Debe ingresar la ciudad")
	@Column(name="city", length = 30)
	private String ciudad;
	
	@Column(name="state", length = 20)
	private String estado;
	
	@Column(name="postalCode")
	private int codigoPostal;
	
	@NotEmpty(message = "Debe ingresar el pais")
	@Column(name="country", length = 15)
	private String pais;
	
	@NotNull(message = "Debe ingresar limite de credito")
	@Column(name="creditLimit")
	private double limiteCredito;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="salesRepEmployeeNumber")
	private Employee empleado;
	
	@OneToMany(mappedBy = "idCliente",cascade = CascadeType.ALL)
	private List<Order> pedidos = new ArrayList<Order>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Long idCliente, int empresaNombre, String apellido, String nombre, int telefono, String direccion1,
			String direccion2, String ciudad, String estado, int codigoPostal, String pais, double limiteCredito,
			Employee empleado) {
		super();
		this.idCliente = idCliente;
		this.empresaNombre = empresaNombre;
		this.apellido = apellido;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.ciudad = ciudad;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.pais = pais;
		this.limiteCredito = limiteCredito;
		this.empleado = empleado;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public int getEmpresaNombre() {
		return empresaNombre;
	}

	public void setEmpresaNombre(int empresaNombre) {
		this.empresaNombre = empresaNombre;
	}

	public Employee getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Employee getNumeroEmpleado() {
		return empleado;
	}

	public void setNumeroEmpleado(Employee empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Customer [idCliente=" + idCliente + ", empresaNombre=" + empresaNombre + ", apellido=" + apellido
				+ ", nombre=" + nombre + ", telefono=" + telefono + ", direccion1=" + direccion1 + ", direccion2="
				+ direccion2 + ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal
				+ ", pais=" + pais + ", limiteCredito=" + limiteCredito + ", empleado=" + empleado + "]";
	}
	
	
	
}
