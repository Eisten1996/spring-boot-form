package com.bolasaideas.springboot.form.app.services;

import java.util.List;

import com.bolasaideas.springboot.form.app.models.domain.Pais;

public interface PaisService {

	public List<Pais> listar();

	public Pais obtenerPorId(Integer id);
}
