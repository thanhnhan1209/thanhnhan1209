package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {

    @Id
    @Column(name = "maNhaCungCap")
    private String maNhaCungCap;

    @Column(name = "tenNhaCungCap")
    private String tenNhaCungCap;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "diaChi")
    private String diaChi;

    public NhaCungCap() {}

    public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String sdt, String diaChi) {
        this.maNhaCungCap = maNhaCungCap;
        this.tenNhaCungCap = tenNhaCungCap;
        this.sdt = sdt;
        this.diaChi = diaChi;
    }

    public String getMaNhaCungCap() {
        return maNhaCungCap;
    }

    public void setMaNhaCungCap(String maNhaCungCap) {
        this.maNhaCungCap = maNhaCungCap;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NhaCungCap{" +
                "maNhaCungCap='" + maNhaCungCap + '\'' +
                ", tenNhaCungCap='" + tenNhaCungCap + '\'' +
                ", sdt='" + sdt + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NhaCungCap)) return false;
        NhaCungCap that = (NhaCungCap) o;
        return Objects.equals(maNhaCungCap, that.maNhaCungCap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maNhaCungCap);
    }
}