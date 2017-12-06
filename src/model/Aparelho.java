package model;

import java.io.Serializable;

public class Aparelho implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_aparelho;
	private String nome;
	private long potencia;
	private String comodo;
	private Bandeira bandeira;
	public Usuario usuario;
	
	public Aparelho() {
		
	}
	
	public Aparelho(String nome, long potencia, String comodo) {
		this.nome = nome;
		this.potencia = potencia;
		this.comodo = comodo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public long getPotencia() {
		return potencia;
	}
	
	public String getComodo() {
		return comodo;
	}
	
	public void setPotencia(long potencia) {
		this.potencia = potencia;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setId_aparelho(int id_aparelho) {
		this.id_aparelho = id_aparelho;
	}
	
	public void setComodo(String comodo) {
		this.comodo = comodo;
	}
	
	public int getId_aparelho() {
		return id_aparelho;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
}
