package dao;

import model.NhaCungCap;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NhaCungCapDAO {

    public static NhaCungCapDAO getInstance() {
        return new NhaCungCapDAO();
    }

    public boolean isMaNhaCungCapExists(String maNhaCungCap) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT count(*) FROM NhaCungCap WHERE maNhaCungCap = :ma";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("ma", maNhaCungCap);
            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public int insert(NhaCungCap ncc) {
        if (isMaNhaCungCapExists(ncc.getMaNhaCungCap())) {
            JOptionPane.showMessageDialog(null, "Mã nhà cung cấp đã tồn tại!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(ncc);
            tx.commit();
            return 1;
        } catch (Exception e) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Không thêm được nhà cung cấp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int update(NhaCungCap ncc) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(ncc);
            tx.commit();
            return 1;
        } catch (Exception e) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Không cập nhật được nhà cung cấp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public int delete(NhaCungCap ncc) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.delete(ncc);
            tx.commit();
            return 1;
        } catch (Exception e) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Không xóa được nhà cung cấp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }

    public List<NhaCungCap> selectAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM NhaCungCap";
            Query<NhaCungCap> query = session.createQuery(hql, NhaCungCap.class);
            return query.list();
        } catch (Exception e) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Không thể lấy danh sách nhà cung cấp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }

    public NhaCungCap selectById(String maNhaCungCap) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(NhaCungCap.class, maNhaCungCap);
        } catch (Exception e) {
            Logger.getLogger(NhaCungCapDAO.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Không thể lấy thông tin nhà cung cấp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}