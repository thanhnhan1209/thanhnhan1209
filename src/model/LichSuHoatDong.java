package model;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "lichsuhoatdong")
public class LichSuHoatDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;

    @Column(columnDefinition = "TEXT")
    private String hanhdong;

    @Temporal(TemporalType.TIMESTAMP)
    private Date thoigian;

    public LichSuHoatDong() {
    }

    public LichSuHoatDong(String username, String hanhdong, Date thoigian) {
        this.username = username;
        this.hanhdong = hanhdong;
        this.thoigian = thoigian;
    }

    // Getters và Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHanhdong() {
        return hanhdong;
    }

    public void setHanhdong(String hanhdong) {
        this.hanhdong = hanhdong;
    }

    public Date getThoigian() {
        return thoigian;
    }

    public void setThoigian(Date thoigian) {
        this.thoigian = thoigian;
    }

    public void setHanhDong(String hanhDong) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setNguoiThucHien(String tenNguoiDung) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setThoiGian(Timestamp timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}