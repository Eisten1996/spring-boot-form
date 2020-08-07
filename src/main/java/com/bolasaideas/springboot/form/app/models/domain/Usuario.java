package com.bolasaideas.springboot.form.app.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.bolasaideas.springboot.form.app.validation.IdentificadorRegex;

public class Usuario {
	// @Pattern(regexp = "[0-9]{2}[,.][\\d]{3}[,.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;
	// @NotEmpty
	private String nombre;
	@NotBlank
	private String apellido;
	@Size(max = 8, min = 3)
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	@Email(message = "Correo con formato incorrecto")
	private String email;

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

}
