package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.service.CursoService;

@Controller
public class CursoController {
	public CursoService service;
	
	public CursoController(CursoService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar/curso")
	public String formulario(Model model) {
		model.addAttribute("cursoDTO", new CursoDTO());
		return "form_curso";
	}
	
	
}
