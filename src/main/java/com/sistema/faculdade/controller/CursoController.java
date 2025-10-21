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
import com.sistema.faculdade.service.DisciplinaService;

import jakarta.validation.Valid;

@Controller
public class CursoController {
	private final CursoService cursoService;
	private final DisciplinaService disciplinaService;
	
	public CursoController(CursoService cursoService, DisciplinaService disciplinaService) {
		this.cursoService = cursoService;
		this.disciplinaService = disciplinaService;
	}
	
	@GetMapping("/cadastrar/curso")
	public String formulario(Model model) {
		model.addAttribute("cursoDTO", new CursoDTO());
		model.addAttribute("disciplinas", disciplinaService.listarDisciplinas());
		return "curso_form";
	}
	
	@PostMapping("/cadastrar/curso")
	public String salvarCurso(@ModelAttribute("cursoDTO") @Valid CursoDTO cursoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "curso_form";
		}
		cursoService.salvarCurso(cursoDTO);
		return "redirect:/cadastrar/curso";
	}
	
	@GetMapping("/cursos")
	public String listarCursos(Model model) {
		model.addAttribute("cursos", cursoService.listarCursos());
		return "cursos";
	}
	
	@GetMapping("/cursos/editar/{id}")
	public String editarCurso(@PathVariable Long id, Model model) {
		CursoDTO dto = cursoService.buscarPorId(id);
		model.addAttribute("cursoDTO", dto);
		model.addAttribute("disciplinas", disciplinaService.listarDisciplinas());
		return "curso_form";
	}
	
	@PutMapping("/cursos/atualizar/{id}")
	public String atualizarCurso(@ModelAttribute CursoDTO cursoDTO, @PathVariable Long id) {
		cursoDTO.setId(id);
		cursoService.salvarCurso(cursoDTO);
		return "redirect:/cursos";
	}
	
	@DeleteMapping("/cursos/excluir/{id}")
	public String excluirCurso(@PathVariable Long id) {
		cursoService.excluirCurso(id);
		return "redirect:/cursos";
	}
}
