package model;

import java.io.Serializable;

import javax.persistence.Column;

public class Consumo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_historico;
	private String data;
	private double valor_em_preco;
	private int quantidade_de_aparelhos;
	private String tipo_calculo = "diario";
	private int quantidade_da_potencia;
	private int consumo_em_horas;
	public Aparelho aparelho;
	public Usuario usuario;
	public Bandeira bandeira;
		
	public void setTipo_calculo(String tipo_calculo) {
		this.tipo_calculo = tipo_calculo;
	}
	
	public String getTipo_calculo() {
		return tipo_calculo;
	}
	
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
	
	public Aparelho getAparelho() {
		return aparelho;
	}
	
	public void setAparelho(Aparelho aparelho) {
		this.aparelho = aparelho;
	}
	
	public int getConsumo_em_horas() {
		return consumo_em_horas;
	}

	public void setConsumo_em_horas(int consumo_em_horas) {
		this.consumo_em_horas = consumo_em_horas;
	}
		
	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public double calculaConsumoMensal(Aparelho aparelho, int consumo_em_horas, Bandeira bandeira, int quantidade_de_aparelhos){
		double whats = (((this.getQuantidade_de_aparelhos() * this.aparelho.getPotencia()) * this.getConsumo_em_horas()) * 30) / 1000;
				
		if(this.bandeira.getBandeiraVerde() == true){
			return whats * 0.66;
		}if(this.bandeira.getBandeiraAmarela() == true){
			if(whats >= 100){
				return ((whats * 0.66) + ((int)(whats) / 100) * 2);
			}
			
			return whats * 0.66;
		}if(this.bandeira.getBandeiraVermelha1() == true){
			if(whats >= 100){
				return ((whats * 0.66) + ((int)(whats) / 100) * 3);
			} 
			
			return whats * 0.66;
		}if(this.bandeira.getBandeiraVermelha2() == true){
			if(whats >= 100){
				return ((whats * 0.66) + ((int)(whats) / 100) * 3.50);
			}
			
			return whats * 0.66;
		}

		return 0;
	}
	
	public double calculaConsumoDiario(Aparelho aparelho, int consumo_em_horas, Bandeira bandeira, int quantidade_de_aparelhos){
		double whats = ((this.getQuantidade_de_aparelhos() * this.aparelho.getPotencia()) * this.getConsumo_em_horas()) / 1000;
		
		if(this.bandeira.getBandeiraVerde() == true){
			return whats * 0.66;
		}if(this.bandeira.getBandeiraAmarela() == true){
			if(whats >= 100){
				return ((whats * 0.66) + ((int)(whats) / 100) * 2);
			}
			
			return whats * 0.66;
		}if(this.bandeira.getBandeiraVermelha1() == true){
			if(whats >= 100){
				return ((whats * 0.66) + ((int)(whats) / 100) * 3);
			}
			
			return whats * 0.66;
		}if(this.bandeira.getBandeiraVermelha2() == true){
			if(whats >= 100){
				return ((whats * 0.66) + ((int)(whats) / 100) * 3.50);
			}
			
			return whats * 0.66;
		}
		
		return 0;		
	}	
}
