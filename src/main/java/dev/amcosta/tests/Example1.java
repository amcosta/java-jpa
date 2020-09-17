package dev.amcosta.tests;

import dev.amcosta.model.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Example1 {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contas");
        EntityManager em = factory.createEntityManager();

        Conta conta = new Conta(293, "amcosta");

        em.getTransaction().begin();
        em.persist(conta);
        em.getTransaction().commit();
        em.close();
    }
}
