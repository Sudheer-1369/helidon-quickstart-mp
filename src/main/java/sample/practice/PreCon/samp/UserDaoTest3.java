/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package sample.practice.PreCon.samp;

import com.oracle.hibernate.decs.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoTest3 {
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ORCL");
    EntityManager entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();

    Integer primaryKey = 1;
    User user = entityManager.find(User.class, primaryKey);
    user.toString();

    entityManager.close();
    factory.close();
  }
}
