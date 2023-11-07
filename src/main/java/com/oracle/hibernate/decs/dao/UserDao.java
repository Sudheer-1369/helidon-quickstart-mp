/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package com.oracle.hibernate.decs.dao;

import com.oracle.hibernate.decs.common.exceptions.DaoException;
import com.oracle.hibernate.decs.entities.User;
import java.util.List;

public interface UserDao {

  void addUser(User user) throws DaoException;

  User getUserById(long userId) throws DaoException;

  List<User> getAllUsers() throws DaoException;

  void updateUser(User user) throws DaoException;

  void deleteUserById(long userId) throws DaoException;

  void deleteUserByCode(String userCode) throws DaoException;
}
