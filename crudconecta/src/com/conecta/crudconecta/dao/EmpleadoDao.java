package com.conecta.crudconecta.dao;

import java.util.Collection;

import com.conecta.crudconecta.model.Empleado;

public interface EmpleadoDao {
	Collection<Empleado> getList();

	void save(Empleado e);

	Empleado get(Long id);

	void update(Empleado e);

	void delete(Long id);
}
