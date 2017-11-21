package model;

import java.io.Serializable;

import javax.persistence.Column;

public class Aparelho implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_aparelho;
	private String nome;
	private long potencia;
	private String comodo;
	
	public String getNome() {
		return nome;
	}
	
	public long getPotencia() {
		return potencia;
	}
	
	public String getComodo() {
		return comodo;
	}
}
