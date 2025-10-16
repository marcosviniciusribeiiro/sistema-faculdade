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

import com.sistema.faculdade.dto.EnderecoDTO;
import com.sistema.faculdade.service.EnderecoService;

import jakarta.validation.Valid;

@Controller
public class EnderecoController {
	public EnderecoService service;
	
	public EnderecoController(EnderecoService service) {
		this.service = service;
	}
	
	@GetMapping("/cadastrar/endereco")
	public String formulario(Model model) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setNumero(0);
		model.addAttribute("enderecoDTO", dto);
		return "endereco_form";
	}
	
	@PostMapping("/cadastrar/endereco")
	public String salvarEndereco(@ModelAttribute("enderecoDTO") @Valid EnderecoDTO enderecoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "endereco_form";
		}
		service.salvarEndereco(enderecoDTO);
		return "redirect:/cadastrar/endereco";
	}
	
	@GetMapping("/enderecos")
	public String listarEnderecos(Model model) {
		model.addAttribute("enderecos", service.listarEnderecos());
		return "enderecos";
	}
	
	@GetMapping("/enderecos/editar/{id}")
	public String editarEndereco(@PathVariable Long id, Model model) {
		EnderecoDTO dto = service.buscarPorId(id);
		model.addAttribute("enderecoDTO", dto);
		return "endereco_form";
	}
	
	@PutMapping("/enderecos/atualizar/{id}")
	public String atualizarEndereco(@ModelAttribute EnderecoDTO enderecoDTO, @PathVariable Long id) {
		enderecoDTO.setId(id);
		service.salvarEndereco(enderecoDTO);
		return "redirect:/enderecos";	
	}
	
	@DeleteMapping("/enderecos/excluir/{id}")
	public String excluirEndereco(@PathVariable Long id) {
		service.excluirEndereco(id);
		return "redirect:/enderecos";
	}
}
