package br.com.milhas;

import javax.persistence.*;
import javax.persistence.GenerationType;

public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name = "nome")
	private String Nome;
	
	@Column(name = "cpf")
	private String Cpf;
	
	@Column(name = "email")
	private String Email;
	
	@Column(name = "telefone")
	private String Telefone;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String email, String telefone) {
		this.Nome = nome;
		this.Cpf = cpf;
		this.Email = email;
		this.Telefone = telefone;
	}
	
	public long getId() {
		return Id;
	}
	
	public String getNome() {
		return Nome;
	}
	
	public String getCpf() {
		return Cpf;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getTelefone() {
		return Telefone;
	}
	
	public void setNome(String nome) {
		this.Nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.Cpf = cpf;
	}
	
	public void setEmail(String email) {
		this.Email = email;
	}
	public void setTelefone(String telefone) {
		this.Telefone = telefone;
	}
	
	@Override 
	
	public String toString() {
		return "Cliente [id=\" + Id + \", Nome=\" + Nome + \", Cpf=\" + Cpf + \", Email=\" + Email + \"]";
		}
	}
