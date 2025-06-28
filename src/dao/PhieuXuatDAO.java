package dao;

import model.PhieuXuat;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class PhieuXuatDAO {

    public static PhieuXuatDAO getInstance() {
        return new PhieuXuatDAO();
    }

    public void insert(PhieuXuat px) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(px);
            tx.commit();
        }
    }

    public void update(PhieuXuat px) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(px);
            tx.commit();
        }
    }

    public void delete(PhieuXuat px) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(px);
            tx.commit();
        }
    }

    public List<PhieuXuat> selectAll() {
        List<PhieuXuat> list = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<PhieuXuat> query = session.createQuery("FROM PhieuXuat ORDER BY thoiGianTao DESC", PhieuXuat.class);
            list = query.list();

            // Gọi DAO lấy chi tiết phiếu xuất
            for (PhieuXuat px : list) {
                px.setChiTietPhieu(((ChiTietPhieuXuatDAO) ChiTietPhieuXuatDAO.getInstance()).selectAll(px.getMaPhieu()));
            }
        }
        return list;
    }

    public PhieuXuat selectById(String maPhieu) {
        PhieuXuat result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.get(PhieuXuat.class, maPhieu);

            if (result != null) {
                result.setChiTietPhieu(((ChiTietPhieuXuatDAO) ChiTietPhieuXuatDAO.getInstance()).selectAll(maPhieu));
            }
        }
        return result;
    }
}