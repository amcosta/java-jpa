package dev.amcosta.examples;

import dev.amcosta.model.BankAccount;
import dev.amcosta.model.Moviment;

import javax.persistence.*;
import java.util.List;

public class Query1 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contas");
        EntityManager em = factory.createEntityManager();

        BankAccount bankAccount = em.find(BankAccount.class, 1L);
        TypedQuery<Moviment> query = em.createQuery("select m from Moviment m where m.conta = :pBankAccount", Moviment.class);
        query.setParameter("pBankAccount", bankAccount);

        List<Moviment> resultList = query.getResultList();
        for (Moviment moviment : resultList) {
            System.out.println(moviment.getDescription());
        }
    }
}
