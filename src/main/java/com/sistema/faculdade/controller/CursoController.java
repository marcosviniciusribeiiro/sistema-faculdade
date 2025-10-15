package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.faculdade.dto.CursoDTO;
import com.sistema.faculdade.service.CursoService;

import jakarta.validation.Valid;

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
	
	@PostMapping("/cadastrar/curso")
	public String salvarCurso(@ModelAttribute("cursoDTO") @Valid CursoDTO cursoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "form_curso";
		}
		service.salvarCurso(cursoDTO);
		return "redirect:/cadastrar/curso";
	}
}
