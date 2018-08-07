package service.dao;

import service.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {
    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public UsersDataSet get(String login, String password) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        //return ((UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult()).getId();
        UsersDataSet res = (UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
        if(res == null) {
            throw new HibernateException("wrong login");
        }
        if(res.getPassword().equals(password)) {
            return res;
        } else {
            throw new HibernateException("wrong password");
        }
    }

    public long getUserId(String login, String password) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet res = (UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
        if(res.getPassword().equals(password)) {
            return res.getId();
        } else {
            throw new HibernateException("wrong password");
        }
    }


    public long addUser(String login, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSet(login, password));
    }
}
