package com.bolasaideas.springboot.form.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolasaideas.springboot.form.app.models.domain.Usuario;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Eisten");
		usuario.setApellido("Flores");
		usuario.setIdentificador("123.456.4-K");
		model.addAttribute("titulo", "Formulario Usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus sessionStatus) {
		model.addAttribute("titulo", "Resultados del form");
		if (result.hasErrors()) {
			return "form";
		}
		model.addAttribute("usuario", usuario);
		sessionStatus.setComplete();
		return "resultado";
	}
}
