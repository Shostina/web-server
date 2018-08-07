package accounts;


import service.DBService;
import service.Service;
import service.ServiceException;

public class AccountService {

    private static Service service;

    private static AccountService accountService;

    public static AccountService instance() {
        if (accountService == null)
            accountService = new AccountService();
        return accountService;
    }

    public AccountService() {
        service = new DBService();
    }

    public void addUser(String login, String password) throws ServiceException {
        service.addUser(login, password);
    }

    public void checkUser(String login, String password) throws ServiceException {
        service.getUserByLogin(login, password);
    }
}
