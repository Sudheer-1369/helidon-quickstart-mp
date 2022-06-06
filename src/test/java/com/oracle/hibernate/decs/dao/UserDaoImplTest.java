package com.oracle.hibernate.decs.dao;

import com.oracle.hibernate.decs.common.exceptions.DaoException;
import com.oracle.hibernate.decs.entities.User;
import io.helidon.microprofile.tests.junit5.HelidonTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.sql.Date;
import java.util.logging.Logger;

@HelidonTest
public class UserDaoImplTest {

    Logger logger = Logger.getLogger(UserDaoImplTest.class.getName());

    @Inject
    private UserDao userDao;

    @Test
    public void testAddUser() throws DaoException {
        logger.info("userDao Checking "+userDao);

        User user1 = new User("Sudheer","Sudheerpatnana45", Date.valueOf("1997-09-04"));
        User user2 = new User("Mounika","MounikaBhogi545",Date.valueOf("1998-05-18"));
        User user3 = new User("Venkata Manikanta","VenkataManikanta99",Date.valueOf("1993-07-18"));
        User user4 = new User("Patnana Manoja","ManojaPatnana63",Date.valueOf("1998-11-22"));

        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);
        userDao.addUser(user4);
    }

}
