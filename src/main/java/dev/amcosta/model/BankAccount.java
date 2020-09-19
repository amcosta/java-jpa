package dev.amcosta.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Random;

@Entity(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String branch;
    private String account;
    private BigDecimal balance;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Client client;

    public BankAccount(Client client) {
        this.client = client;
        this.balance = new BigDecimal(0);
        this.buildBankAccount();
    }

    public BankAccount() {

    }

    private void buildBankAccount() {
        this.branch = String.format("%03d", new Random().nextInt(999 + 1));
        this.account = String.format("%06d", new Random().nextInt(899999 + 1)  + 100000);
    }

    public void deposit(BigDecimal value) {
        this.balance.add(value);
    }

    public void withdraw(BigDecimal value) {
        if (this.balance.doubleValue() <= 0) {
            throw new RuntimeException("Não há saldo suficiente para essa operação");
        }

        this.balance.subtract(value);
    }

    public String getHolder() {
        return this.client.getName();
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "branch='" + branch + '\'' +
                ", account='" + account + '\'' +
                '}';
    }
}
