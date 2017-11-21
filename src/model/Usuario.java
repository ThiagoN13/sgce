package model;

import java.io.Serializable;

import javax.persistence.Column;

public class Usuario implements Serializable {
	private int id_usuario;
	private String nome;
	private String login;
	private String email;
	private String senha;
	private String tipo_usuario;
}
