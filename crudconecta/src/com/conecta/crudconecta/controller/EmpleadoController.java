package com.conecta.crudconecta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.conecta.crudconecta.model.Empleado;
import com.conecta.crudconecta.service.EmpleadoService;

@Controller
@RequestMapping(value = "/empleado")
public class EmpleadoController {

	private static final String REGISTRO_EMPLEADO = "empleado/registro";
	private static final String REDIRECT = "redirect:/empleado/registro";

	@Autowired
	EmpleadoService empleadoService;

	@RequestMapping(value = "/registro")
	public String registrarEmpleado(Model model) {
		obtenerEmpleado(model, new Empleado());
		return REGISTRO_EMPLEADO;
	}

	@RequestMapping(value = "/guardar-actualizar", method = RequestMethod.POST)
	public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleadoForm) {
		Long idEmpleado = empleadoForm.getId();
		if (idEmpleado != null) {
			empleadoService.update(empleadoForm);
		} else {
			empleadoService.save(empleadoForm);
		}
		return REDIRECT;
	}

	@RequestMapping(value = "/{id}/eliminar")
	public String eliminarEmpleado(@PathVariable("id") Long id) {
		empleadoService.delete(id);
		return REDIRECT;
	}
	
	@RequestMapping(value = "/{id}/actualizar")
	public String actualizarEmpleado(@PathVariable("id") Long id, Model model) {
		obtenerEmpleado(model, empleadoService.get(id));
		return REGISTRO_EMPLEADO;
	}
	
	private void obtenerEmpleado(Model model, Empleado empleado){
		List<Empleado> empleados = (List<Empleado>) empleadoService.getList();
		model.addAttribute("empleado", empleado);
		model.addAttribute("empleados", empleados);
	}

}
