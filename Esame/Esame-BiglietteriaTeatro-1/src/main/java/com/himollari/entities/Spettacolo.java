package com.himollari.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "spettacoli")
public class Spettacolo {

 @Id
 @Column(name = "COD_SPETTACOLO")
 private String codSpettacolo;

 @Column(name = "TITOLO")
 private String titolo;

 @Column(name = "AUTORE")
 private String autore;

 @Column(name = "REGISTA")
 private String regista;

 @Column(name = "PREZZO")
 private double prezzo;

 @Column(name = "COD_TEATRO")
 private String codTeatro;

 // Costruttori
 public Spettacolo() {}

 public Spettacolo(String codSpettacolo, String titolo, String autore, String regista, double prezzo, String codTeatro) {
     this.codSpettacolo = codSpettacolo;
     this.titolo = titolo;
     this.autore = autore;
     this.regista = regista;
     this.prezzo = prezzo;
     this.codTeatro = codTeatro;
 }

 // Getters e Setters
 public String getCodSpettacolo() {
     return codSpettacolo;
 }

 public void setCodSpettacolo(String codSpettacolo) {
     this.codSpettacolo = codSpettacolo;
 }

 public String getTitolo() {
     return titolo;
 }

 public void setTitolo(String titolo) {
     this.titolo = titolo;
 }

 public String getAutore() {
     return autore;
 }

 public void setAutore(String autore) {
     this.autore = autore;
 }

 public String getRegista() {
     return regista;
 }

 public void setRegista(String regista) {
     this.regista = regista;
 }

 public double getPrezzo() {
     return prezzo;
 }

 public void setPrezzo(double prezzo) {
     this.prezzo = prezzo;
 }

 public String getCodTeatro() {
     return codTeatro;
 }

 public void setCodTeatro(String codTeatro) {
     this.codTeatro = codTeatro;
 }
}

