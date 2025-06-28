package dao;

import model.ChiTietPhieu;
import model.ChiTietPhieuId;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import util.HibernateUtil;

import java.util.List;

public class ChiTietPhieuXuatDAO {

    // Singleton
    private static ChiTietPhieuXuatDAO instance;

    public static ChiTietPhieuXuatDAO getInstance() {
        if (instance == null) {
            instance = new ChiTietPhieuXuatDAO();
        }
        return instance;
    }

    public void insert(ChiTietPhieu ctp) {
        String sql = "INSERT INTO ChiTietPhieuXuat (maPhieu, maSP, soLuong, donGia) VALUES (:maPhieu, :maSP, :soLuong, :donGia)";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery(sql);
            query.setParameter("maPhieu", ctp.getMaPhieu());
            query.setParameter("maSP", ctp.getMaSP());
            query.setParameter("soLuong", ctp.getSoLuong());
            query.setParameter("donGia", ctp.getDonGia());
            query.executeUpdate();
            tx.commit();
        }
    }

    public void update(ChiTietPhieu ctp) {
        String sql = "UPDATE ChiTietPhieuXuat SET soLuong = :soLuong, donGia = :donGia WHERE maPhieu = :maPhieu AND maSP = :maSP";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery(sql);
            query.setParameter("soLuong", ctp.getSoLuong());
            query.setParameter("donGia", ctp.getDonGia());
            query.setParameter("maPhieu", ctp.getMaPhieu());
            query.setParameter("maSP", ctp.getMaSP());
            query.executeUpdate();
            tx.commit();
        }
    }

    public void delete(ChiTietPhieuId id) {
        String sql = "DELETE FROM ChiTietPhieuXuat WHERE maPhieu = :maPhieu AND maSP = :maSP";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            NativeQuery<?> query = session.createNativeQuery(sql);
            query.setParameter("maPhieu", id.getMaPhieu());
            query.setParameter("maSP", id.getMaSP());
            query.executeUpdate();
            tx.commit();
        }
    }

    public List<ChiTietPhieu> selectAll(String maPhieu) {
        String sql = "SELECT * FROM ChiTietPhieuXuat WHERE maPhieu = :maPhieu";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<ChiTietPhieu> query = session.createNativeQuery(sql, ChiTietPhieu.class);
            query.setParameter("maPhieu", maPhieu);
            return query.list();
        }
    }

    public List<ChiTietPhieu> selectAll() {
        String sql = "SELECT * FROM ChiTietPhieuXuat";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<ChiTietPhieu> query = session.createNativeQuery(sql, ChiTietPhieu.class);
            return query.list();
        }
    }

    public ChiTietPhieu selectById(ChiTietPhieuId id) {
        String sql = "SELECT * FROM ChiTietPhieuXuat WHERE maPhieu = :maPhieu AND maSP = :maSP";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<ChiTietPhieu> query = session.createNativeQuery(sql, ChiTietPhieu.class);
            query.setParameter("maPhieu", id.getMaPhieu());
            query.setParameter("maSP", id.getMaSP());
            return query.uniqueResult();
        }
    }

    public void delete(ChiTietPhieu i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}