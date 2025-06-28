package dao;

import model.SanPham;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    public static SanPhamDAO getInstance() {
        return new SanPhamDAO();
    }

    // Thêm sản phẩm
    public int insert(SanPham sp) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(sp);
            tx.commit();
            return 1;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    // Cập nhật sản phẩm
    public int update(SanPham sp) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.update(sp);
            tx.commit();
            return 1;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    // ❌ Loại bỏ delete cũ dùng delete(hard)
    // public int delete(SanPham sp) { ... }

    // ✅ Soft delete: chuyển trạng thái sản phẩm về 0
    public int delete(String maSP) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            SanPham sp = session.get(SanPham.class, maSP);
            if (sp != null) {
                sp.setTrangThai(0);
                session.update(sp);
                tx.commit();
                return 1;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    // Lấy tất cả sản phẩm (kể cả đã xoá)
    public List<SanPham> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SanPham> query = session.createQuery("FROM SanPham", SanPham.class);
            return query.list();
        }
    }

    // Lấy tất cả sản phẩm đang hoạt động
    public List<SanPham> selectAllExist() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SanPham> query = session.createQuery("FROM SanPham WHERE trangThai = 1", SanPham.class);
            return query.list();
        }
    }

    // Lấy sản phẩm còn tồn kho
    public List<SanPham> selectAllTonKho() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SanPham> query = session.createQuery("FROM SanPham WHERE soLuong > 0 AND trangThai = 1", SanPham.class);
            return query.list();
        }
    }

    // Lấy theo mã
    public SanPham selectById(String maSP) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(SanPham.class, maSP);
        }
    }

    // Cập nhật số lượng sản phẩm
    public int updateSoLuong(String maSP, int soLuongMoi) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            SanPham sp = session.get(SanPham.class, maSP);
            if (sp != null) {
                sp.setSoLuong(soLuongMoi);
                session.update(sp);
                tx.commit();
                return 1;
            }
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return 0;
    }

    // Đếm sản phẩm đang hoạt động
    public long getSoLuongSanPhamTonTai() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM SanPham WHERE trangThai = 1", Long.class);
            return query.uniqueResult();
        }
    }

    // Tổng số lượng sản phẩm đang hoạt động
    public int getSl() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                "SELECT SUM(soLuong) FROM SanPham WHERE trangThai = 1", Long.class
            );
            Long result = query.uniqueResult();
            return result != null ? result.intValue() : 0;
        }
    }

    // Giữ lại nếu bạn cần mock/fake dữ liệu
    public ArrayList<SanPham> selectAllE() {
        return new ArrayList<>();
    }

    public void deleteTrangThai(String maSP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}