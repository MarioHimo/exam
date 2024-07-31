package com.himollari.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "repliche")
public class Replica {

 @Id
 @Column(name = "COD_REPLICA")
 private String codReplica;

 @Column(name = "COD_SPETTACOLO")
 private String codSpettacolo;

 @Column(name = "DATA_ORA")
 private Date dataReplica;

 // Costruttori
 public Replica() {}

 public Replica(String codReplica, String codSpettacolo, Date dataReplica) {
     this.codReplica = codReplica;
     this.codSpettacolo = codSpettacolo;
     this.dataReplica = dataReplica;
 }

 // Getters e Setters
 public String getCodReplica() {
     return codReplica;
 }

 public void setCodReplica(String codReplica) {
     this.codReplica = codReplica;
 }

 public String getCodSpettacolo() {
     return codSpettacolo;
 }

 public void setCodSpettacolo(String codSpettacolo) {
     this.codSpettacolo = codSpettacolo;
 }

 public Date getDataReplica() {
     return dataReplica;
 }

 public void setDataReplica(Date dataReplica) {
     this.dataReplica = dataReplica;
 }
}

