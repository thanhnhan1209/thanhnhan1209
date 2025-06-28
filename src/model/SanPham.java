package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "SanPham")  // Tên bảng trong CSDL
public class SanPham {

    @Id
    @Column(name = "maSP")
    private String maSP;

    @Column(name = "tenSP")
    private String tenSP;

    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "gia")
    private double gia;

    @Column(name = "phanLoai")
    private String phanLoai;

    @Column(name = "xuatXu")
    private String xuatXu;

    @Column(name = "trangThai")
    private int trangThai;

    public SanPham() {}

    public SanPham(String maSP, String tenSP, int soLuong, double gia, String phanLoai, String xuatXu, int trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.gia = gia;
        this.phanLoai = phanLoai;
        this.xuatXu = xuatXu;
        this.trangThai = trangThai;
    }

    // Getters & Setters
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSP='" + maSP + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", soLuong=" + soLuong +
                ", gia=" + gia +
                ", phanLoai='" + phanLoai + '\'' +
                ", xuatXu='" + xuatXu + '\'' +
                ", trangThai=" + trangThai +
                '}';
    }
}
