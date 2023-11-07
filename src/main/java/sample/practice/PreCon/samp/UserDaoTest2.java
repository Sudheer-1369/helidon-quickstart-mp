/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package sample.practice.PreCon.samp;

// Update the exisiting user

import com.oracle.hibernate.decs.entities.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserDaoTest2 {
  public static void main(String[] args) {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("ORCL");
    EntityManager entityManager = factory.createEntityManager();
    entityManager.getTransaction().begin();

    User user = new User();

    /*user.setId(1);
           user.setEmail("SudheerPatnana45@gmail.com");
           user.setFullName("Patnana Sudheer Kumar");
           user.setPassword("Sudheer Sudheer");
    */
    entityManager.merge(user);

    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();
  }
}
