package com.bolasaideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolasaideas.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImpl implements PaisService {
	private List<Pais> lista;

	public PaisServiceImpl() {
		lista = Arrays.asList(new Pais(1, "PE", "Peru"), new Pais(2, "AR", "Argentina"), new Pais(3, "BR", "Brasil"));
	}

	@Override
	public List<Pais> listar() {
		return lista;
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		for (Pais pais : lista) {
			if (id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
