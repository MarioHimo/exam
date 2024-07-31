package com.himollari.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "biglietti")
public class Biglietto {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "COD_OPERAZIONE")
 private String codOperazione;

 @Column(name = "COD_CLIENTE")
 private int codCliente;

 @Column(name = "COD_REPLICA")
 private String codReplica;

 @Column(name = "DATA_ORA")
 private Timestamp dataOra;

 @Column(name = "TIPO_PAGAMENTO")
 private String tipoPagamento;

 @Column(name = "QUANTITA")
 private int quantita;

 // Costruttori
 public Biglietto() {}

 public Biglietto(int codCliente, String codReplica, Timestamp dataOra, String tipoPagamento, int quantita) {
     this.codCliente = codCliente;
     this.codReplica = codReplica;
     this.dataOra = dataOra;
     this.tipoPagamento = tipoPagamento;
     this.quantita = quantita;
 }

 // Getters e Setters
 public String getCodOperazione() {
     return codOperazione;
 }

 public void setCodOperazione(String codOperazione) {
     this.codOperazione = codOperazione;
 }

 public int getCodCliente() {
     return codCliente;
 }

 public void setCodCliente(int codCliente) {
     this.codCliente = codCliente;
 }

 public String getCodReplica() {
     return codReplica;
 }

 public void setCodReplica(String codReplica) {
     this.codReplica = codReplica;
 }

 public Timestamp getDataOra() {
     return dataOra;
 }

 public void setDataOra(Timestamp dataOra) {
     this.dataOra = dataOra;
 }

 public String getTipoPagamento() {
     return tipoPagamento;
 }

 public void setTipoPagamento(String tipoPagamento) {
     this.tipoPagamento = tipoPagamento;
 }

 public int getQuantita() {
     return quantita;
 }

 public void setQuantita(int quantita) {
     this.quantita = quantita;
 }
}
