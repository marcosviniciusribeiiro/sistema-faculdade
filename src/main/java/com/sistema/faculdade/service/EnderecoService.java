package com.sistema.faculdade.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.faculdade.dto.EnderecoDTO;
import com.sistema.faculdade.mapper.EnderecoMapper;
import com.sistema.faculdade.model.Endereco;
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
	
	public List<EnderecoDTO> listarEnderecos(){
		return enderecoRepository.findAll().stream().map(EnderecoMapper::toDTO).toList();
	}
	
	public EnderecoDTO buscarPorId(Long id) {
		Endereco e = enderecoRepository.findById(id)
									   .orElseThrow(() -> new IllegalArgumentException("Id inválido: " + id));
		return EnderecoMapper.toDTO(e);
	}
	
	public void deletarEndereco(Long id) {
		enderecoRepository.deleteById(id);
	}
}
