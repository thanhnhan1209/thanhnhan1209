package dao;

import model.ChiTietPhieu;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ChiTietPhieuNhapDAO implements DAOInterface<ChiTietPhieu> {

    public static ChiTietPhieuNhapDAO getInstance() {
        return new ChiTietPhieuNhapDAO();
    }

    @Override
    public int insert(ChiTietPhieu t) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(t);
            tx.commit();
            return 1;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(ChiTietPhieu t) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(t);
            tx.commit();
            return 1;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delete(ChiTietPhieu t) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(t);
            tx.commit();
            return 1;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList<ChiTietPhieu> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<ChiTietPhieu> list = session.createQuery("FROM ChiTietPhieu", ChiTietPhieu.class).list();
            return new ArrayList<>(list);
        }
    }

    @Override
    public ChiTietPhieu selectById(String maPhieu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(ChiTietPhieu.class, maPhieu);
        }
    }

    public ArrayList<ChiTietPhieu> selectAll(String maPhieu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<ChiTietPhieu> list = session
                    .createQuery("FROM ChiTietPhieu WHERE maPhieu = :maPhieu", ChiTietPhieu.class)
                    .setParameter("maPhieu", maPhieu)
                    .list();
            return new ArrayList<>(list);
        }
    }
}