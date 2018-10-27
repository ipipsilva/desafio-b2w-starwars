package br.com.desafiob2w.starwars.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Planeta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1500878868758162087L;
	
	@Id
	private String id;
	
	private String nome;
	private String terreno;
	private String clima;
	private Integer quantidadeFilmes;
	
	public Planeta() {
		super();
	}

	public Planeta(String nome, String clima) {
		super();
		this.nome = nome;
		this.clima = clima;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTerreno() {
		return terreno;
	}
	
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	
	public String getClima() {
		return clima;
	}
	
	public void setClima(String clima) {
		this.clima = clima;
	}
	
	public Integer getQuantidadeFilmes() {
		return quantidadeFilmes;
	}
	
	public void setQuantidadeFilmes(Integer quantidadeFilmes) {
		this.quantidadeFilmes = quantidadeFilmes;
	}
	
	@Override
	public String toString() {
		return String.format("[Id: %s, Nome: %s, Terreno: %s, Clima: %s, QuantidadeFilmes: %s]", id, nome, terreno, clima, quantidadeFilmes);
	}
}