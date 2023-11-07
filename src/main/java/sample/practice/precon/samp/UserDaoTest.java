/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package sample.practice.precon.samp;
// Creating a new user

import com.oracle.hibernate.decs.entities.User;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class UserDaoTest {

  @PersistenceContext private static EntityManager entityManager;

  /*
  public static void main(String[] args) {

      /*
      EntityManagerFactory factory = Persistence.createEntityManagerFactory("ORCL");
      EntityManager entityManager = factory.createEntityManager();
      entityManager.getTransaction().begin();

      User user = new User();
      user.setEmail("sudheerpatnana456@gmail.com");
      user.setFullName("Sudheer Kumar");
      user.setPassword("Sudheer patnana");

      entityManager.persist(user);

      entityManager.getTransaction().commit();
      entityManager.close();
      factory.close();

  }
  */

  public static User deleteAllUsers() {
    System.out.println(entityManager);
    User user = entityManager.find(User.class, 1);
    //  System.out.println(user);
    return user;
  }

  public static void main(String[] args) {
    System.out.println(deleteAllUsers());
  }
}
