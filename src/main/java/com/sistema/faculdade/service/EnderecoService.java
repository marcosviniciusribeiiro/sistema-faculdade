package com.sistema.faculdade.service;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.EnderecoDTO;
import com.sistema.faculdade.mapper.EnderecoMapper;
import com.sistema.faculdade.repository.EnderecoRepository;

@Service
public class EnderecoService {
	public EnderecoRepository enderecoRepository;
	
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}
	
	public void salvarEndereco(EnderecoDTO dto) {
		enderecoRepository.save(EnderecoMapper.toEntity(dto));
	}
	
	public void deletarEndereco(Long id) {
		enderecoRepository.deleteById(id);
	}
}
