package dao;

import java.util.ArrayList;
import java.util.List;

import model.PhieuNhap;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class PhieuNhapDAO {

    public static PhieuNhapDAO getInstance() {
        return new PhieuNhapDAO();
    }

    public boolean insert(PhieuNhap pn) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(pn);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(PhieuNhap pn) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(pn);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(PhieuNhap pn) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.delete(pn);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public List<PhieuNhap> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM PhieuNhap ORDER BY thoiGianTao DESC", PhieuNhap.class).list();
        }
    }

    public PhieuNhap selectById(String maPhieu) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PhieuNhap.class, maPhieu);
        }
    }

    // Có thể xoá nếu chưa dùng
    public List<PhieuNhap> selectAllAccount(String maAcc) {
        // Nếu bạn cần lọc theo người tạo, hãy sửa lại query bên dưới
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<PhieuNhap> query = session.createQuery(
                "FROM PhieuNhap WHERE nguoiTao = :maAcc ORDER BY thoiGianTao DESC", PhieuNhap.class);
            query.setParameter("maAcc", maAcc);
            return query.list();
        }
    }

    public ArrayList<PhieuNhap> selectAllP() {
        ArrayList<PhieuNhap> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<PhieuNhap> query = session.createQuery("FROM PhieuNhap ORDER BY thoiGianTao DESC", PhieuNhap.class);
            list.addAll(query.list());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}