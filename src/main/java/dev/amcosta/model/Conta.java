package dev.amcosta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "contas")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer agencia;
    private String titular;

    public Conta(Integer agencia, String titular) {
        this.agencia = agencia;
        this.titular = titular;
    }
}
