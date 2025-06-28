package model;

public class ThongKeDoanhThuPhanLoai {
    private String phanLoai;
    private long tongTien;

    public ThongKeDoanhThuPhanLoai(String phanLoai, long tongTien) {
        this.phanLoai = phanLoai;
        this.tongTien = tongTien;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public long getTongTien() {
        return tongTien;
    }

    public void setTongTien(long tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "ThongKeDoanhThuPhanLoai{" + "phanLoai=" + phanLoai + ", tongTien=" + tongTien + '}';
    }
}