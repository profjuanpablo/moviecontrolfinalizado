package com.projeto.moviecontrol.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.moviecontrol.domain.filme.DadosAlterarFilmes;
import com.projeto.moviecontrol.domain.filme.DadosCadastrarFilmes;
import com.projeto.moviecontrol.domain.filme.Filme;
import com.projeto.moviecontrol.domain.filme.FilmeRepository;

@Controller
@RequestMapping("/filmes")
public class FilmeController {
	
	//private List<Filme> filmes 	= new ArrayList<>();
	
	@Autowired
	private FilmeRepository repository;
	
	
	@GetMapping("/formulario")
	public String carregaPaginaFormulario(Long id, Model model) {
		if (id != null) {
			var filme = repository.getReferenceById(id);
			model.addAttribute("filme", filme);
		}
		return "filmes/formulario";
		}
	
	@GetMapping
	public String carregaListagem(Model model) {
		model.addAttribute("lista", repository.findAll());
		return "filmes/listagem";
		
	}
	
	@PostMapping
	@Transactional
	public String 
	cadastrarFilme(DadosCadastrarFilmes dados ) {
		var filme = new Filme(dados);
		repository.save(filme);
				
		return "redirect:/filmes";
		
	}
	
	
	@PutMapping
	@Transactional
	public String alterarFilme(DadosAlterarFilmes dados ) {
		var filme = repository.getReferenceById(dados.id());
		filme.atualizarDados(dados);
				
		return "redirect:/filmes";
		
	}
	
	
	@DeleteMapping
	public String removerFilme(Long id) {
		repository.deleteById(id);
		return "redirect:/filmes";
	}
	

}
