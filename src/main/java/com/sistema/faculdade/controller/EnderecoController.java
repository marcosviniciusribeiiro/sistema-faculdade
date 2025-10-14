package com.sistema.faculdade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		model.addAttribute("enderecoDTO", new EnderecoDTO());
		return "form_endereco";
	}
	
	@PostMapping("/cadastrar/endereco")
	public String salvarEndereco(@ModelAttribute("enderecoDTO") @Valid EnderecoDTO enderecoDTO, BindingResult result) {
		if(result.hasErrors()) {
			return "form_endereco";
		}
		service.salvarEndereco(enderecoDTO);
		return "redirect:/cadastrar/endereco";
	}
}
