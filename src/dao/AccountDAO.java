package dao;

import java.util.List;
import model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class AccountDAO {

    public static AccountDAO getInstance() {
        return new AccountDAO();
    }

    public void insert(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void update(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Account account) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(account);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Account selectById(String userName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Account.class, userName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Account> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Account> query = session.createQuery("from Account", Account.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updatePassword(String email, String newPassword) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update Account set password = :pass where email = :email");
            query.setParameter("pass", newPassword);
            query.setParameter("email", email);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
