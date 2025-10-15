package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;

import com.sistema.faculdade.service.ProfessorService;

@Controller
public class ProfessorController {
	public ProfessorService service;
	
	public ProfessorController(ProfessorService service) {
		this.service = service;
	}
}
