package com.conecta.crudconecta.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conecta.crudconecta.dao.EmpleadoDao;
import com.conecta.crudconecta.model.Empleado;
import com.conecta.crudconecta.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoDao empleadoDao;

	@Override
	public Collection<Empleado> getList() {
		return empleadoDao.getList();
	}

	@Override
	public void save(Empleado e) {
		empleadoDao.save(e);

	}

	@Override
	public Empleado get(Long id) {
		return empleadoDao.get(id);
	}

	@Override
	public void update(Empleado e) {
		empleadoDao.update(e);

	}

	@Override
	public void delete(Long id) {
		empleadoDao.delete(id);

	}

}
