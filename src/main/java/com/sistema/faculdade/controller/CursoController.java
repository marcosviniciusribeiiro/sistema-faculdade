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
	
	@GetMapping("/cursos")
	public String listarCursos(Model model) {
		model.addAttribute("cursos", service.listarCursos());
		return "cursos";
	}
	
	@GetMapping("/cursos/editar/{id}")
	public String editarCurso(@PathVariable Long id, Model model) {
		CursoDTO dto = service.buscarPorId(id);
		model.addAttribute("cursoDTO", dto);
		return "form_curso";
	}
	
	@PutMapping("/cursos/atualizar/{id}")
	public String atualizarCurso(@ModelAttribute CursoDTO cursoDTO, @PathVariable Long id) {
		cursoDTO.setId(id);
		service.salvarCurso(cursoDTO);
		return "redirect:/cursos";
	}
	
	@DeleteMapping("/cursos/excluir/{id}")
	public String excluirCurso(@PathVariable Long id) {
		service.excluirCurso(id);
		return "redirect:/cursos";
	}
}
