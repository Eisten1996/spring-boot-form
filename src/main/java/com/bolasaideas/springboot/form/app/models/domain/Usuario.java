package com.bolasaideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.bolasaideas.springboot.form.app.validation.IdentificadorRegex;
import com.bolasaideas.springboot.form.app.validation.Requerido;

public class Usuario {
	// @Pattern(regexp = "[0-9]{2}[,.][\\d]{3}[,.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;
	// @NotEmpty
	private String nombre;
	// @NotBlank
	@Requerido
	private String apellido;
	@Size(max = 8, min = 3)
	private String username;
	@NotBlank
	private String password;
	@Requerido
	@Email(message = "Correo con formato incorrecto")
	private String email;
	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;
	@NotNull
	@Past
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;
	@NotNull
	private Pais pais;
	@NotEmpty
	private List<Role> roles;
	private Boolean habilitar;
	@NotEmpty
	private String genero;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
