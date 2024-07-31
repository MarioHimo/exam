package com.himollari.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@Column(name = "COD_CLIENTE")
	private int codCliente;
	
	@Column(name = "COGNOME")
	private String cognome; 
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "EMAIL")
	private String email;
	
	 // Costruttori
    public Cliente() {}

    public Cliente(int codCliente, String cognome, String nome, String telefono, String email) {
        this.codCliente = codCliente;
        this.cognome = cognome;
        this.nome = nome;
        this.telefono = telefono;
        this.email = email;
    }

    // Getters e Setters
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}




