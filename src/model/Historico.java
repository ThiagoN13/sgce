package model;

import java.io.Serializable;

import javax.persistence.Column;

public class Historico implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_historico;
	private String data;//reanalizar  o tipo
	private double valor_em_preco;
	private String bandeiras;
	private int quantidade_de_aparelhos;
	private int quantidade_da_potencia;
	private Aparelho fk_aparelho;
	
	public int getId_historico() {
		return id_historico;
	}
	
	public void setId_historico(int id_historico) {
		this.id_historico = id_historico;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public double getValor_em_preco() {
		return valor_em_preco;
	}
	
	public void setValor_em_preco(double valor_em_preco) {
		this.valor_em_preco = valor_em_preco;
	}
	
	public String getBandeiras() {
		return bandeiras;
	}
	
	public void setBandeiras(String bandeiras) {
		this.bandeiras = bandeiras;
	}
	
	public int getQuantidade_de_aparelhos() {
		return quantidade_de_aparelhos;
	}
	
	public void setQuantidade_de_aparelhos(int quantidade_de_aparelhos) {
		this.quantidade_de_aparelhos = quantidade_de_aparelhos;
	}
	
	public int getQuantidade_da_potencia() {
		return quantidade_da_potencia;
	}
	
	public void setQuantidade_da_potencia(int quantidade_da_potencia) {
		this.quantidade_da_potencia = quantidade_da_potencia;
	}
	
	public Aparelho getFk_aparelho() {
		return fk_aparelho;
	}
	
	public void setFk_aparelho(Aparelho fk_aparelho) {
		this.fk_aparelho = fk_aparelho;
	}
}
