package dao;

import model.ThongKeProduct;
import model.ThongKeDoanhThuPhanLoai;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ThongKeDAO {

    private static ThongKeDAO instance;

    public static ThongKeDAO getInstance() {
        if (instance == null) {
            instance = new ThongKeDAO();
        }
        return instance;
    }

    public static List<ThongKeDoanhThuPhanLoai> thongKeDoanhThuTheoPhanLoai() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // 1. Thống kê số lượng nhập - xuất theo khoảng thời gian
    public List<ThongKeProduct> getThongKe(Date timeStart, Date timeEnd) {
        List<ThongKeProduct> result = new ArrayList<>();
        String sql = "SELECT t1.maSP, tenSP, slNhap, slXuat FROM ( " +
                "  SELECT maSP, SUM(soLuong) AS slNhap FROM ChiTietPhieuNhap " +
                "  JOIN PhieuNhap ON PhieuNhap.maPhieu = ChiTietPhieuNhap.maPhieu " +
                "  WHERE thoiGianTao BETWEEN :start AND :end " +
                "  GROUP BY maSP " +
                ") t1 " +
                "JOIN ( " +
                "  SELECT maSP, SUM(soLuong) AS slXuat FROM ChiTietPhieuXuat " +
                "  JOIN PhieuXuat ON PhieuXuat.maPhieu = ChiTietPhieuXuat.maPhieu " +
                "  WHERE thoiGianTao BETWEEN :start2 AND :end2 " +
                "  GROUP BY maSP " +
                ") t2 ON t1.maSP = t2.maSP " +
                "JOIN SanPham ON t1.maSP = SanPham.maSP";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Object[]> query = session.createNativeQuery(sql);
            query.setParameter("start", new Timestamp(timeStart.getTime()));
            query.setParameter("end", new Timestamp(timeEnd.getTime()));
            query.setParameter("start2", new Timestamp(timeStart.getTime()));
            query.setParameter("end2", new Timestamp(timeEnd.getTime()));

            List<Object[]> rows = query.list();
            for (Object[] row : rows) {
                String maSP = (String) row[0];
                String tenSP = (String) row[1];
                int slNhap = ((Number) row[2]).intValue();
                int slXuat = ((Number) row[3]).intValue();
                result.add(new ThongKeProduct(maSP, tenSP, slNhap, slXuat));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // 2. Thống kê tổng số lượng nhập xuất tất cả sản phẩm
    public List<ThongKeProduct> getThongKe() {
        List<ThongKeProduct> result = new ArrayList<>();
        String sql = "SELECT t1.maSP, tenSP, slNhap, slXuat FROM ( " +
                "  SELECT maSP, SUM(soLuong) AS slNhap FROM ChiTietPhieuNhap " +
                "  JOIN PhieuNhap ON PhieuNhap.maPhieu = ChiTietPhieuNhap.maPhieu " +
                "  GROUP BY maSP " +
                ") t1 " +
                "JOIN ( " +
                "  SELECT maSP, SUM(soLuong) AS slXuat FROM ChiTietPhieuXuat " +
                "  JOIN PhieuXuat ON PhieuXuat.maPhieu = ChiTietPhieuXuat.maPhieu " +
                "  GROUP BY maSP " +
                ") t2 ON t1.maSP = t2.maSP " +
                "JOIN SanPham ON t1.maSP = SanPham.maSP";

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            NativeQuery<Object[]> query = session.createNativeQuery(sql);
            List<Object[]> rows = query.list();

            for (Object[] row : rows) {
                String maSP = (String) row[0];
                String tenSP = (String) row[1];
                int slNhap = ((Number) row[2]).intValue();
                int slXuat = ((Number) row[3]).intValue();
                result.add(new ThongKeProduct(maSP, tenSP, slNhap, slXuat));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    // 3. Thống kê doanh thu theo phân loại sản phẩm (cho biểu đồ)
  public List<ThongKeDoanhThuPhanLoai> getThongKeDoanhThuTheoPhanLoai() {
    List<ThongKeDoanhThuPhanLoai> result = new ArrayList<>();

    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        String hql = "SELECT ctpx.sanPham.phanLoai, SUM(ctpx.soLuong * ctpx.donGia) " +
                     "FROM ChiTietPhieuXuat ctpx " +
                     "GROUP BY ctpx.sanPham.phanLoai";

        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> list = query.list();

        for (Object[] row : list) {
            String loai = (String) row[0];
            Double tongTienDouble = (Double) row[1];
            long tongTien = tongTienDouble != null ? tongTienDouble.longValue() : 0;
            result.add(new ThongKeDoanhThuPhanLoai(loai, tongTien));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    return result;
}public List<Object[]> getDoanhThuTheoThoiGian() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Object[]> result = new ArrayList<>();
    try {
        String hql = "SELECT DATE(p.thoiGianTao), SUM(p.tongTien) FROM PhieuXuat p GROUP BY DATE(p.thoiGianTao) ORDER BY DATE(p.thoiGianTao)";
        Query query = session.createQuery(hql);
        result = query.getResultList();
    } finally {
        session.close();
    }
    return result;
}
public List<Object[]> getSoLuongNhapXuatTheoSanPham() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<Object[]> result = null;

    try {
        String sql = "SELECT t1.maSP, sp.tenSP, t1.slNhap, t2.slXuat " +
                "FROM ( " +
                "    SELECT maSP, SUM(soLuong) AS slNhap " +
                "    FROM ChiTietPhieuNhap " +
                "    GROUP BY maSP " +
                ") t1 " +
                "JOIN ( " +
                "    SELECT maSP, SUM(soLuong) AS slXuat " +
                "    FROM ChiTietPhieuXuat " +
                "    GROUP BY maSP " +
                ") t2 ON t1.maSP = t2.maSP " +
                "JOIN SanPham sp ON t1.maSP = sp.maSP";

        NativeQuery<Object[]> query = session.createNativeQuery(sql);
        result = query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        session.close();
    }

    return result;
}

    public ArrayList<Object[]> getSoLuongNhapXuat() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}