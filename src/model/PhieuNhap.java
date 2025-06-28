package model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name = "PhieuNhap")
public class PhieuNhap extends Phieu {

    @Column(name = "maNhaCungCap")
    private String nhaCungCap;

    public PhieuNhap() {
        super(); // Gọi constructor rỗng của lớp cha Phieu
    }

    public PhieuNhap(String nhaCungCap, String maPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien) {
        super(maPhieu, thoiGianTao, nguoiTao, tongTien);
        this.nhaCungCap = nhaCungCap;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public String toString() {
        return "PhieuNhap{" +
                "maPhieu='" + getMaPhieu() + '\'' +
                ", nhaCungCap='" + nhaCungCap + '\'' +
                '}';
    }
}