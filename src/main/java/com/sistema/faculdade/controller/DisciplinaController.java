package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;

import com.sistema.faculdade.service.DisciplinaService;

@Controller
public class DisciplinaController {
	public DisciplinaService service;
	
	public DisciplinaController(DisciplinaService service) {
		this.service = service;
	}
}
