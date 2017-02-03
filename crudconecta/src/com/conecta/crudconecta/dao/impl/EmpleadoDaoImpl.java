package com.conecta.crudconecta.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.conecta.crudconecta.dao.EmpleadoDao;
import com.conecta.crudconecta.model.Empleado;


@Transactional
@Repository
public class EmpleadoDaoImpl implements EmpleadoDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Empleado> getList() {
		try {
			Query<Empleado> query = getSession().createQuery("FROM Empleado e WHERE e.estado = :estado");
			query.setParameter("estado", Boolean.TRUE);
			return query.getResultList();
		} catch (HibernateException error) {
			System.err.println("Ocurrio el siguiente error al obtener la lista de empleados " + error.getMessage());
			return new ArrayList<>();
		}
	}

	@Override
	public void save(Empleado e) {
		try {
			Timestamp ts = new Timestamp(new Date().getTime());
			e.setFechaCreacion(ts);
			e.setFechaActualizacion(ts);
			e.setEstado(Boolean.TRUE);
			getSession().save(e);
		} catch (HibernateException error) {
			System.err.println("Ocurrio el siguiente error al registrar el empleado " + error.getMessage());
		}

	}

	@SuppressWarnings("rawtypes")
	@Override
	public Empleado get(Long id) {
		try {
			Query query = getSession().createQuery("FROM Empleado e WHERE e.id = :id");
			query.setParameter("id", id);
			List queryList = query.getResultList();
			if (queryList == null && queryList.isEmpty()) {
				return null;
			} else {
				return (Empleado) queryList.get(0);
			}
		} catch (HibernateException error) {
			System.err.println("Ocurrio el siguiente error al obtener el empleado " + error.getMessage());
			return null;
		}
	}

	@Override
	public void update(Empleado e) {
		try {
			Timestamp ts = new Timestamp(new Date().getTime());
			e.setFechaActualizacion(ts);
			getSession().update(e);
		} catch (HibernateException error) {
			System.err.println("Ocurrio el siguiente error al actualizar el empleado " + error.getMessage());
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void delete(Long id) {
		try {
			Query query = getSession().createQuery("FROM Empleado ad WHERE ad.id = :id");
			query.setParameter("id", id);
			List queryList = query.getResultList();
			if (queryList != null && queryList.isEmpty()) {
			} else {
				Empleado e = (Empleado) queryList.get(0);
				e.setEstado(Boolean.FALSE);
				getSession().update(e);
			}
		} catch (HibernateException error) {
			System.err.println("Ocurrio el siguiente error al eliminar el empleado " + error.getMessage());
		}
	}
}
