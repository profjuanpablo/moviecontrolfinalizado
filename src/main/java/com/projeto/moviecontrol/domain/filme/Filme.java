package com.projeto.moviecontrol.domain.filme;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer duracaoEmMinutos;
	private Integer anoLancamento;
	private String genero;
	
	//Construtor da classe
	public Filme(DadosCadastrarFilmes dados) {
		this.nome = dados.nome();
		this.duracaoEmMinutos =dados.duracao();
		this.anoLancamento = dados.ano();
		this.genero = dados.genero();
	}
	
	//construtor generico
	public Filme() {}
	
	
	
	
	@Override
	public String toString() {
		return "Filme [nome=" + nome + ", duracaoEmMinutos=" + duracaoEmMinutos + ", anoLancamento=" + anoLancamento
				+ ", genero=" + genero + "]";
	}
	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getDuracaoEmMinutos() {
		return duracaoEmMinutos;
	}
	public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
		this.duracaoEmMinutos = duracaoEmMinutos;
	}
	public Integer getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(Integer anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public void atualizarDados(DadosAlterarFilmes dados) {
		this.nome = dados.nome();
		this.duracaoEmMinutos = dados.duracao();
		this.anoLancamento = dados.ano();
		this.genero = dados.genero();
	}
	
}
