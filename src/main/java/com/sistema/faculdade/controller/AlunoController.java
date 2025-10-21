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

import com.sistema.faculdade.dto.AlunoDTO;
import com.sistema.faculdade.dto.EnderecoDTO;
import com.sistema.faculdade.service.AlunoService;
import com.sistema.faculdade.service.CursoService;
import com.sistema.faculdade.service.EnderecoService;

import jakarta.validation.Valid;

@Controller
public class AlunoController {
	private final AlunoService alunoService;
	private final CursoService cursoService;
	private final EnderecoService enderecoService;
	
	public AlunoController(AlunoService alunoService, CursoService cursoService, EnderecoService enderecoService) {
		this.alunoService = alunoService;
		this.cursoService = cursoService;
		this.enderecoService = enderecoService;
		
	}
	
	@GetMapping("/sistema/faculdade")
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastrar/aluno")
	public String formulario(Model model) {
		AlunoDTO alunoDTO = new AlunoDTO();
		alunoDTO.setEndereco(new EnderecoDTO());
		
		model.addAttribute("alunoDTO", new AlunoDTO());
		model.addAttribute("cursos", cursoService.listarCursos());
		return "aluno_form";
	}
	
	@PostMapping("/cadastrar/aluno")
	public String salvarAluno(@ModelAttribute("alunoDTO") @Valid AlunoDTO alunoDTO, BindingResult result) {
	    if(alunoDTO.getCursoId() == null) {
	        result.rejectValue("cursoId", null, "O curso é obrigatório.");
	    }
	    
		if(result.hasErrors()) {
			return "aluno_form";
		}
		alunoService.salvarAluno(alunoDTO);
		return "redirect:/cadastrar/aluno";
	}
	
	@GetMapping("/alunos")
	public String listarAlunos(Model model) {
		model.addAttribute("alunos", alunoService.listarAlunos());
		return "alunos";
	}

	@GetMapping("/alunos/editar/{id}")
	public String editarAluno(@PathVariable Long id, Model model){
		AlunoDTO dto = alunoService.buscarPorId(id);
		model.addAttribute("alunoDTO", dto);
		model.addAttribute("cursos", cursoService.listarCursos());
		model.addAttribute("enderecos", enderecoService.listarEnderecos());
		return "aluno_form";
	}	
	
	@PutMapping("/alunos/atualizar/{id}")
	public String atualizarAluno(@ModelAttribute AlunoDTO alunoDTO, @PathVariable Long id) {
		alunoDTO.setId(id);
		alunoService.salvarAluno(alunoDTO);
		return "redirect:/alunos";
	}

	@DeleteMapping("alunos/excluir/{id}")
	public String excluirAluno(@PathVariable Long id) {
		alunoService.excluirAluno(id);
		return "redirect:/alunos";
	}
}