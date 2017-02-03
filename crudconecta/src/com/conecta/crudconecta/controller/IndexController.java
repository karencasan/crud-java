package com.conecta.crudconecta.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final String INDEX = "index";

	@RequestMapping(value = { "/", "/inicio" })
	public String getIndex() {
		return INDEX;
	}
}
