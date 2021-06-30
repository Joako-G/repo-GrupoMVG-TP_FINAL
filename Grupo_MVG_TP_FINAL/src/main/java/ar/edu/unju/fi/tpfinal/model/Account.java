package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "ACCOUNTS")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	@NotEmpty(message = "Ingrese nombre de usuario")
	private String nombreUsuario;
	
	@NotEmpty(message = "Ingrese contraseña")
	private String password;
	
	private String rol;
	
	//Relacion con Employee
	@OneToOne(mappedBy = "cuenta", fetch = FetchType.LAZY)
	private Employee empleado;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(Long id, @NotEmpty(message = "Ingrese nombre de usuario") String nombreUsuario,
			@NotEmpty(message = "Ingrese contraseña") String password, String rol,
			@Valid Employee empleado) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
		this.empleado = empleado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Employee getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Employee empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", rol=" + rol
				+ ", empleado=" + empleado + "]";
	}
	
}
