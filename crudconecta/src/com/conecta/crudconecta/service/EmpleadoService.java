package com.conecta.crudconecta.service;

import java.util.Collection;

import com.conecta.crudconecta.model.Empleado;

public interface EmpleadoService {
	Collection<Empleado> getList();

	void save(Empleado ad);

	Empleado get(Long id);

	void update(Empleado e);

	void delete(Long id);
}
