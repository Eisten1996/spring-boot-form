package com.bolasaideas.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolasaideas.springboot.form.app.editors.NombreMayusculaEditor;
import com.bolasaideas.springboot.form.app.editors.PaisPropertyEditor;
import com.bolasaideas.springboot.form.app.models.domain.Pais;
import com.bolasaideas.springboot.form.app.models.domain.Role;
import com.bolasaideas.springboot.form.app.models.domain.Usuario;
import com.bolasaideas.springboot.form.app.services.PaisService;
import com.bolasaideas.springboot.form.app.services.RoleService;
import com.bolasaideas.springboot.form.app.validation.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;

	@Autowired
	private PaisService paisService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private PaisPropertyEditor paisEditor;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
		binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
	}

	@ModelAttribute("listaRoles")
	public List<Role> listaRoles() {
		return roleService.listar();
	}

	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
		return paisService.listar();
	}

	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString() {
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERADOR");
		return roles;
	}

	@ModelAttribute("listaRolesMap")
	public Map<String, String> listaRolesMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERADOR", "Moderador");
		return roles;
	}

	@ModelAttribute("paises")
	public List<String> paises() {
		return Arrays.asList("Peru", "Argentina", "Brasil");
	}

	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("PE", "Peru");
		paises.put("AR", "Argentina");
		paises.put("BR", "Brasil");
		return paises;
	}

	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Eisten");
		usuario.setApellido("Flores");
		usuario.setIdentificador("13.456.448-K");
		model.addAttribute("titulo", "Formulario Usuario");
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus sessionStatus) {
		// validador.validate(usuario, result);
		model.addAttribute("titulo", "Resultados del form");
		if (result.hasErrors()) {
			return "form";
		}
		model.addAttribute("usuario", usuario);
		sessionStatus.setComplete();
		return "resultado";
	}
}
