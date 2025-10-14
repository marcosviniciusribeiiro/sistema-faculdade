package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.faculdade.dto.AlunoDTO;
import com.sistema.faculdade.model.Aluno;
import com.sistema.faculdade.service.AlunoService;

import jakarta.validation.Valid;

@Controller
public class AlunoController {
	public AlunoService service;
	
	public AlunoController(AlunoService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar/aluno")
	public String formulario(Model model) {
		model.addAttribute("alunoDTO", new Aluno());
		return "form_aluno";
	}
	
	@PostMapping("/cadastrar/aluno")
	public String salvarAluno(@ModelAttribute("alunoDTO") @Valid AlunoDTO alunoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "form_aluno";
		}
		service.salvarAluno(alunoDTO);
		return "redirect://cadastrar/aluno";
	}
}
