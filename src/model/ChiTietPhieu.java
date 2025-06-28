package model;

import javax.persistence.*;

@Entity
@Table(name = "ChiTietPhieuNhap")  // Tên bảng trong cơ sở dữ liệu
public class ChiTietPhieu {

    @EmbeddedId
    private ChiTietPhieuId id;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "donGia")
    private double donGia;

    public ChiTietPhieu() {}

    public ChiTietPhieu(String maPhieu, String maSP, int soLuong, double donGia) {
        this.id = new ChiTietPhieuId(maPhieu, maSP);
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public ChiTietPhieuId getId() {
        return id;
    }

    public void setId(ChiTietPhieuId id) {
        this.id = id;
    }

    public String getMaPhieu() {
        return id.getMaPhieu();
    }

    public String getMaSP() {
        return id.getMaSP();
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "ChiTietPhieu{" +
                "maPhieu='" + getMaPhieu() + '\'' +
                ", maSP='" + getMaSP() + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}