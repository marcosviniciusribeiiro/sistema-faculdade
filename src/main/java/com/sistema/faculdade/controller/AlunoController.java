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
import com.sistema.faculdade.service.CursoService;
import com.sistema.faculdade.service.EnderecoService;

import jakarta.validation.Valid;

@Controller
public class AlunoController {
	public AlunoService alunoService;
	public CursoService cursoService;
	public EnderecoService enderecoService;
	
	public AlunoController(AlunoService alunoService, CursoService cursoService, EnderecoService enderecoService) {
		this.alunoService = alunoService;
		this.cursoService = cursoService;
		this.enderecoService = enderecoService;
		
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
		alunoService.salvarAluno(alunoDTO);
		return "redirect://cadastrar/aluno";
	}
	//Listar Alunos = "/alunos"
	//Editar Aluno = "/alunos/editar/{id}"
	//Atualizar Aluno = "alunos/atualizar/{id}"
	//Deletar Aluno = "alunos/deletar/{id}"
}