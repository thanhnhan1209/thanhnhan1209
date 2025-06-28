package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ChiTietPhieuId implements Serializable {

    @Column(name = "maPhieu")
    private String maPhieu;

    @Column(name = "maSP")
    private String maSP;

    public ChiTietPhieuId() {}

    public ChiTietPhieuId(String maPhieu, String maSP) {
        this.maPhieu = maPhieu;
        this.maSP = maSP;
    }

    public String getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(String maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietPhieuId)) return false;
        ChiTietPhieuId that = (ChiTietPhieuId) o;
        return Objects.equals(maPhieu, that.maPhieu) &&
               Objects.equals(maSP, that.maSP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maPhieu, maSP);
    }
}
