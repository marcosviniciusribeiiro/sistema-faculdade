package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.sistema.faculdade.dto.DisciplinaDTO;
import com.sistema.faculdade.service.DisciplinaService;

import jakarta.validation.Valid;

@Controller
public class DisciplinaController {
	public DisciplinaService service;
	
	public DisciplinaController(DisciplinaService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar/disciplina")
	public String formulario(Model model) {
		model.addAttribute("disciplinaDTO", new DisciplinaDTO());
		return "disciplina_form";
	}
	
	@PostMapping("/cadastrar/disciplina")
	public String salvarDisciplina(@ModelAttribute("disciplinaDTO") @Valid DisciplinaDTO disciplinaDTO, BindingResult result) {
		if(result.hasErrors()){
			return "disciplina_form";
		}
		service.salvarDisciplina(disciplinaDTO);
		return "redirect:/cadastrar/disciplina";
	}
	
	@GetMapping("/disciplinas")
	public String listarDisciplinas(Model model) {
		model.addAttribute("disciplinas", service.listarDisciplinas());
		return "disciplinas";
	}
	
	@GetMapping("/disciplinas/editar/{id}")
	public String editarDisciplina(Model model, @PathVariable Long id) {
		DisciplinaDTO dto = service.buscarPorId(id);
		model.addAttribute("disciplinaDTO", dto);
		return "disciplina_form";
	}
	
	//AtualizarDisciplina ("/disciplinas/atualizar/{id}")
	@PutMapping("/disciplinas/atualizar/{id}")
	public String atualizarDisciplina(@ModelAttribute DisciplinaDTO disciplinaDTO, @PathVariable Long id) {
		disciplinaDTO.setId(id);
		service.salvarDisciplina(disciplinaDTO);
		return "redirect:/disciplinas";
	}
	
	@DeleteMapping("/disciplinas/excluir/{id}")
	public String excluirDisciplina(@PathVariable Long id) {
		service.excluirDisciplina(id);
		return "redirect:/disciplinas";
	}
}