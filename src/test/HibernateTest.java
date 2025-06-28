package test;

import org.hibernate.Session;
import util.HibernateUtil;

public class HibernateTest {
    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            System.out.println("✅ Hibernate đã kết nối thành công!");
        } catch (Exception e) {
            System.err.println("❌ Lỗi khi kết nối Hibernate: " + e.getMessage());
        }
    }
}
