package service;

import service.dataSets.UsersDataSet;
public interface Service {

    UsersDataSet getUserById(long id) throws ServiceException;

    UsersDataSet getUserByLogin(String login, String password) throws ServiceException;

    long addUser(String login, String password) throws ServiceException;
}
