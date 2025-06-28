package controller;

import dao.AccountDAO;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class SearchAccount {

    public static SearchAccount getInstance() {
        return new SearchAccount();
    }

    public ArrayList<Account> searchTatCaAcc(String text) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Account a WHERE lower(a.fullName) LIKE :text OR lower(a.user) LIKE :text OR lower(a.role) LIKE :text";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("text", "%" + text.toLowerCase() + "%");
            return new ArrayList<>(query.list());
        }
    }

    public ArrayList<Account> searchFullName(String text) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Account a WHERE lower(a.fullName) LIKE :text";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("text", "%" + text.toLowerCase() + "%");
            return new ArrayList<>(query.list());
        }
    }

    public ArrayList<Account> searchUserName(String text) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Account a WHERE lower(a.user) LIKE :text";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("text", "%" + text.toLowerCase() + "%");
            return new ArrayList<>(query.list());
        }
    }

    public ArrayList<Account> searchRole(String text) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Account a WHERE lower(a.role) LIKE :text";
            Query<Account> query = session.createQuery(hql, Account.class);
            query.setParameter("text", "%" + text.toLowerCase() + "%");
            return new ArrayList<>(query.list());
        }
    }
}
