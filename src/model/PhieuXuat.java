package model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "PhieuXuat")
public class PhieuXuat extends Phieu {

    // Thuộc tính lưu danh sách chi tiết phiếu xuất
    @Transient // Không ánh xạ Hibernate vì bạn dùng DAO riêng
    private List<ChiTietPhieu> chiTietPhieu;

    public PhieuXuat() {}

    public PhieuXuat(String maPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien) {
        super(maPhieu, thoiGianTao, nguoiTao, tongTien);
    }

    public PhieuXuat(String maPhieu, Timestamp thoiGianTao, String nguoiTao, List<ChiTietPhieu> chiTietPhieu, double tongTien) {
        super(maPhieu, thoiGianTao, nguoiTao, tongTien);
        this.chiTietPhieu = chiTietPhieu;
    }

    public List<ChiTietPhieu> getChiTietPhieu() {
        return chiTietPhieu;
    }

    public void setChiTietPhieu(List<ChiTietPhieu> chiTietPhieu) {
        this.chiTietPhieu = chiTietPhieu;
    }

    @Override
    public String toString() {
        return "PhieuXuat{" +
                "maPhieu='" + getMaPhieu() + '\'' +
                '}';
    }
}