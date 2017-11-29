package model;

import java.io.Serializable;

public class Bandeira implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_bandeira;
	private boolean bandeiraVerde;
	private boolean bandeiraAmarela;
	private boolean bandeiraVermelha1;
	private boolean bandeiraVermelha2;
		
	public Bandeira(){
		
	}
	
	public Bandeira(boolean bandeiraVerde, boolean bandeiraAmarela, boolean bandeiraVermelha1, boolean bandeiraVermelha2){
		this.bandeiraVerde = bandeiraVerde;
		this.bandeiraAmarela = bandeiraAmarela;
		this.bandeiraVermelha1 = bandeiraVermelha1;
		this.bandeiraVermelha2 = bandeiraVermelha2;
	}

	public int getId_bandeira() {
		return id_bandeira;
	}

	public void setId_bandeira(int id_bandeira) {
		this.id_bandeira = id_bandeira;
	}

	public boolean getBandeiraVerde() {
		return bandeiraVerde;
	}

	public void setBandeiraVerde(boolean bandeiraVerde) {
		this.bandeiraVerde = bandeiraVerde;
	}

	public boolean getBandeiraAmarela() {
		return bandeiraAmarela;
	}

	public void setBandeiraAmarela(boolean bandeiraAmarela) {
		this.bandeiraAmarela = bandeiraAmarela;
	}

	public boolean getBandeiraVermelha1() {
		return bandeiraVermelha1;
	}

	public void setBandeiraVermelha1(boolean bandeiraVermelha1) {
		this.bandeiraVermelha1 = bandeiraVermelha1;
	}

	public boolean getBandeiraVermelha2() {
		return bandeiraVermelha2;
	}

	public void setBandeiraVermelha2(boolean bandeiraVermelha2) {
		this.bandeiraVermelha2 = bandeiraVermelha2;
	}
}
