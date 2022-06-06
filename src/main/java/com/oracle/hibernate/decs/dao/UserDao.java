/*
 * Copyright (C) 2021 - 2022, Sudheer Kumar Patnana, All rights reserved.
 */

package com.oracle.hibernate.decs.dao;

import com.oracle.hibernate.decs.common.exceptions.DaoException;
import com.oracle.hibernate.decs.entities.User;

import java.util.List;

public interface UserDao {

    public void addUser(User user) throws DaoException;

    public User getUserById(long userId) throws DaoException;

    public List<User> getAllUsers() throws DaoException;

    public void updateUser(User user) throws DaoException;

    public void deleteUserById(long userId) throws DaoException;

    public void deleteUserByCode(String userCode) throws DaoException;

}
