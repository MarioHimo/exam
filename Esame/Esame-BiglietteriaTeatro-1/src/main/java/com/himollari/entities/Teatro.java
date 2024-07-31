package com.himollari.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teatro")
public class Teatro {

 @Id
 @Column(name = "COD_TEATRO")
 private String codTeatro;

 @Column(name = "NOME")
 private String nome;

 @Column(name = "INDIRIZZO")
 private String indirizzo;

 @Column(name = "CITTA")
 private String citta;

 @Column(name = "PROVINCIA")
 private String provincia;

 @Column(name = "TELEFONO")
 private String telefono;

 @Column(name = "POSTI")
 private int posti;

 // Costruttori
 public Teatro() {}

 public Teatro(String codTeatro, String nome, String indirizzo, String citta, String provincia, String telefono, int posti) {
     this.codTeatro = codTeatro;
     this.nome = nome;
     this.indirizzo = indirizzo;
     this.citta = citta;
     this.provincia = provincia;
     this.telefono = telefono;
     this.posti = posti;
 }

 // Getters e Setters
 public String getCodTeatro() {
     return codTeatro;
 }

 public void setCodTeatro(String codTeatro) {
     this.codTeatro = codTeatro;
 }

 public String getNome() {
     return nome;
 }

 public void setNome(String nome) {
     this.nome = nome;
 }

 public String getIndirizzo() {
     return indirizzo;
 }

 public void setIndirizzo(String indirizzo) {
     this.indirizzo = indirizzo;
 }

 public String getCitta() {
     return citta;
 }

 public void setCitta(String citta) {
     this.citta = citta;
 }

 public String getProvincia() {
     return provincia;
 }

 public void setProvincia(String provincia) {
     this.provincia = provincia;
 }

 public String getTelefono() {
     return telefono;
 }

 public void setTelefono(String telefono) {
     this.telefono = telefono;
 }

 public int getPosti() {
     return posti;
 }

 public void setPosti(int posti) {
     this.posti = posti;
 }
}
