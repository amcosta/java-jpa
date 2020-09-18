package dev.amcosta.examples;

import dev.amcosta.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContaComSaldo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contas");
        EntityManager em = factory.createEntityManager();

        Conta conta = new Conta(399, "Spelunk");
        conta.setSaldo(50.0);

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();

        System.out.println("Conta: " + conta.getTitular());
    }
}
