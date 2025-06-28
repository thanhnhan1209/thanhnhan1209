package controller;

import java.util.ArrayList;
import java.util.List;
import model.NhaCungCap;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class SearchNhaCungCap {

    public static SearchNhaCungCap getInstance() {
        return new SearchNhaCungCap();
    }

    public ArrayList<NhaCungCap> searchTatCa(String text) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM NhaCungCap ncc WHERE "
                       + "lower(ncc.maNhaCungCap) LIKE :text OR "
                       + "lower(ncc.tenNhaCungCap) LIKE :text OR "
                       + "lower(ncc.diaChi) LIKE :text OR "
                       + "lower(ncc.sdt) LIKE :text";
            Query<NhaCungCap> query = session.createQuery(hql, NhaCungCap.class);
            query.setParameter("text", "%" + text.toLowerCase() + "%");
            return new ArrayList<>(query.list());
        }
    }

    public ArrayList<NhaCungCap> searchTenNCC(String text) {
        return searchByField("tenNhaCungCap", text);
    }

    public ArrayList<NhaCungCap> searchMaNCC(String text) {
        return searchByField("maNhaCungCap", text);
    }

    public ArrayList<NhaCungCap> searchDiaChi(String text) {
        return searchByField("diaChi", text);
    }

    public ArrayList<NhaCungCap> searchSdt(String text) {
        return searchByField("sdt", text);
    }

    private ArrayList<NhaCungCap> searchByField(String field, String text) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM NhaCungCap ncc WHERE lower(ncc." + field + ") LIKE :text";
            Query<NhaCungCap> query = session.createQuery(hql, NhaCungCap.class);
            query.setParameter("text", "%" + text.toLowerCase() + "%");
            return new ArrayList<>(query.list());
        }
    }
}
