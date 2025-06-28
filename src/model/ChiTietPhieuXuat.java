package model;

import javax.persistence.*;

@Entity
@Table(name = "ChiTietPhieuXuat")
public class ChiTietPhieuXuat {

    @EmbeddedId
    private ChiTietPhieuId id;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "donGia")
    private double donGia;

    @ManyToOne
    @JoinColumn(name = "maSP", referencedColumnName = "maSP", insertable = false, updatable = false)
    private SanPham sanPham;

    public ChiTietPhieuXuat() {}

    public ChiTietPhieuXuat(String maPhieu, String maSP, int soLuong, double donGia) {
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

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }
}