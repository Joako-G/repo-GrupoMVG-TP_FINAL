package ar.edu.unju.fi.tpfinal.model;

import java.math.BigDecimal;
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
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CUSTOMERS")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customerNumber")
	public Long idCliente;
	
	@NotEmpty(message = "Debe ingresar nombre de la empresa/negocio")
	@Column(name="customerName", length = 50)
	private String clienteNombre;
	
	@NotEmpty(message = "Debe ingresar apellido del cliente")
	@Column(name="contactLastName", length = 50)
	private String apellido;
	
	@NotEmpty(message = "Debe ingresar nombre del cliente")
	@Column(name="contactFirstName", length = 50)
	private String nombre;
	
	@NotNull
	@Column(name="phone", length = 50)
	private String telefono;
	
	@NotEmpty(message = "Debe ingresar la direccion")
	@Column(name="addressLine1",length = 50)
	private String direccion1;
	
	@Column(name="addressLine2",length = 50)
	private String direccion2;
	
	@Column(name="city", length = 50)
	private String ciudad;
	
	@Column(name="state", length = 50)
	private String estado;
	
	@Column(name="postalCode", length = 15)
	private String codigoPostal;
	
	@NotEmpty(message = "Debe ingresar el pais")
	@Column(name="country", length = 50)
	private String pais;
	
	@NotNull(message = "Debe ingresar limite de credito")
	@Column(name="creditLimit")
	private BigDecimal limiteCredito;
	
	//Relacion con Employee
	@Autowired
	@ManyToOne
	@JoinColumn(name="salesRepEmployeeNumber")
	private Employee empleado;
	
	//Relacion con Order
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Order> pedidos = new ArrayList<Order>();
	
	//Relacion con Payment
	@OneToMany(mappedBy = "id.customer")
	private List<Payment> payments = new ArrayList<Payment>();
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Long idCliente,
			@NotEmpty(message = "Debe ingresar nombre de la empresa/negocio") String clienteNombre,
			@NotEmpty(message = "Debe ingresar apellido del cliente") String apellido,
			@NotEmpty(message = "Debe ingresar nombre del cliente") String nombre, @NotNull String telefono,
			@NotEmpty(message = "Debe ingresar la direccion") String direccion1, String direccion2,
			@NotEmpty(message = "Debe ingresar la ciudad") String ciudad, String estado, String codigoPostal,
			@NotEmpty(message = "Debe ingresar el pais") String pais,
			@NotNull(message = "Debe ingresar limite de credito") BigDecimal limiteCredito, Employee empleado) {
		super();
		this.idCliente = idCliente;
		this.clienteNombre = clienteNombre;
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

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
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

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public BigDecimal getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(BigDecimal limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Employee getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}

	public List<Order> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Order> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "Customer [idCliente=" + idCliente + ", clienteNombre=" + clienteNombre + ", apellido=" + apellido
				+ ", nombre=" + nombre + ", telefono=" + telefono + ", direccion1=" + direccion1 + ", direccion2="
				+ direccion2 + ", ciudad=" + ciudad + ", estado=" + estado + ", codigoPostal=" + codigoPostal
				+ ", pais=" + pais + ", limiteCredito=" + limiteCredito + "]";
	}

	
	
}
