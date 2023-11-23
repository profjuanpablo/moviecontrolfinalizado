package com.projeto.moviecontrol.domain.filme;

public record DadosAlterarFilmes(
		Long id,
		String nome,
		Integer duracao,
		Integer ano, 
		String genero) {

}
