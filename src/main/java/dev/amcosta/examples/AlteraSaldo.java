package dev.amcosta.examples;

import dev.amcosta.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlteraSaldo {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contas");
        EntityManager em = factory.createEntityManager();

        Conta conta = em.find(Conta.class, 1L);

        em.getTransaction().begin();
        conta.setSaldo(159.99);
        em.getTransaction().commit();

        System.out.println("Conta: " + conta.getTitular());
    }
}
