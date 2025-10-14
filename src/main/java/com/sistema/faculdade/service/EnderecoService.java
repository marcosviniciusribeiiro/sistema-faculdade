package com.sistema.faculdade.service;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.repository.EnderecoRepository;

@Service
public class EnderecoService {
	public EnderecoRepository enderecoRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
}
