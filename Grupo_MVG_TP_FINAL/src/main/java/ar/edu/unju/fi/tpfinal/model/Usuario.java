package ar.edu.unju.fi.tpfinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Entity
@Table(name="USUARIOS")
@Component
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	@NotEmpty(message = "Ingrese nombre de usuario")
	private String nombreUsuario;
	
	@NotEmpty(message = "Ingrese password")	
	private String password;
		
	@Column(name = "rol")
	@NotEmpty(message = "Ingrese rol")
	private String rol;
	
	//Relacion con Employee
	@Autowired
	@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Employee empleado;
	
	//Relacion con Customer
	@Autowired
	@OneToOne(mappedBy = "usuario", fetch = FetchType.LAZY)
	private Customer cliente;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Long id, String nombreUsuario, String password, String rol) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.rol = rol;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", password=" + password + ", rol=" + rol + "]";
	}
	
}
