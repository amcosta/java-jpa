package dev.amcosta.examples;

import dev.amcosta.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertMovements1 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(new Client("Sebastião Pereira"));

        Moviment moviment = new Moviment();
        moviment.setBankAccout(bankAccount);
        moviment.setType(MovimentTypeEnum.OUT);
        moviment.setDescription("Festa de fim de ano");
        moviment.setValue(new BigDecimal("1239.85"));
        moviment.setCategories(Arrays.asList(new Category("Festa"), new Category("Caixa 2")));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("contas");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(moviment);
        em.getTransaction().commit();
    }
}
