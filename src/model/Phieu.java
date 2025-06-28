package model;

import java.sql.Timestamp;
import javax.persistence.*;

@MappedSuperclass
public class Phieu {

    @Id
    @Column(name = "maPhieu")
    private String maPhieu;

    @Column(name = "thoiGianTao")
    private Timestamp thoiGianTao;

    @Column(name = "nguoiTao")
    private String nguoiTao;

    @Column(name = "tongTien")
    private double tongTien;

    public Phieu() {
    }

    public Phieu(String maPhieu, Timestamp thoiGianTao, String nguoiTao, double tongTien) {
        this.maPhieu = maPhieu;
        this.thoiGianTao = thoiGianTao;
        this.nguoiTao = nguoiTao;
        this.tongTien = tongTien;
    }

    // Getters & Setters
    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public Timestamp getThoiGianTao() {
        return thoiGianTao;
    }

    public void setThoiGianTao(Timestamp thoiGianTao) {
        this.thoiGianTao = thoiGianTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}