package controller;

import java.util.ArrayList;
import java.util.List;

import model.SanPham;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class SearchProduct {

    public static SearchProduct getInstance() {
        return new SearchProduct();
    }

    private ArrayList<SanPham> getProducts(String hql, String param, Object value) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<SanPham> query = session.createQuery(hql, SanPham.class);
            if (param != null && value != null) {
                query.setParameter(param, value);
            }
            return new ArrayList<>(query.list());
        }
    }

    public ArrayList<SanPham> searchTatCa(String text) {
        String hql = "FROM SanPham s WHERE s.trangThai = 1 AND (lower(s.maSP) LIKE :text OR lower(s.tenSP) LIKE :text OR lower(s.xuatXu) LIKE :text)";
        return getProducts(hql, "text", "%" + text.toLowerCase() + "%");
    }

    public ArrayList<SanPham> searchMaSP(String text) {
        String hql = "FROM SanPham s WHERE s.trangThai = 1 AND lower(s.maSP) LIKE :text";
        return getProducts(hql, "text", "%" + text.toLowerCase() + "%");
    }

    public ArrayList<SanPham> searchTenSP(String text) {
        String hql = "FROM SanPham s WHERE s.trangThai = 1 AND lower(s.tenSP) LIKE :text";
        return getProducts(hql, "text", "%" + text.toLowerCase() + "%");
    }

    public ArrayList<SanPham> searchSoLuong(String text) {
        try {
            int soLuong = Integer.parseInt(text);
            String hql = "FROM SanPham s WHERE s.trangThai = 1 AND s.soLuong > :soLuong";
            return getProducts(hql, "soLuong", soLuong);
        } catch (NumberFormatException e) {
            return new ArrayList<>();
        }
    }

    public ArrayList<SanPham> searchDonGia(String text) {
        try {
            double gia = Double.parseDouble(text);
            String hql = "FROM SanPham s WHERE s.trangThai = 1 AND s.gia > :gia";
            return getProducts(hql, "gia", gia);
        } catch (NumberFormatException e) {
            return new ArrayList<>();
        }
    }

    public ArrayList<SanPham> searchXuatXu(String text) {
        String hql = "FROM SanPham s WHERE s.trangThai = 1 AND lower(s.xuatXu) LIKE :text";
        return getProducts(hql, "text", "%" + text.toLowerCase() + "%");
    }

    public ArrayList<SanPham> searchDaXoa(String text) {
        String hql = "FROM SanPham s WHERE s.trangThai = 0 AND lower(s.maSP) LIKE :text";
        return getProducts(hql, "text", "%" + text.toLowerCase() + "%");
    }

    public SanPham searchId(String text) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM SanPham s WHERE lower(s.maSP) = :text AND s.trangThai = 1";
            Query<SanPham> query = session.createQuery(hql, SanPham.class);
            query.setParameter("text", text.toLowerCase());
            return query.uniqueResult();
        }
    }
}
