package dao;

import model.LichSuHoatDong;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LichSuHoatDongDAO {

    // Ghi log một dòng mới
    public static void themLog(String hanhDong, String tenNguoiDung) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();

            LichSuHoatDong log = new LichSuHoatDong();
            log.setHanhDong(hanhDong);
            log.setNguoiThucHien(tenNguoiDung);
            log.setThoiGian(new java.sql.Timestamp(System.currentTimeMillis()));

            session.save(log);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}