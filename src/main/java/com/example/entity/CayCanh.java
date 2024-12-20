package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "CAY_CANH")
public class CayCanh {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "ten_cay_canh")
    private String tenCayCanh;

    @Column(name = "loai_cay_canh")
    private String loaiCayCanh;

    @Column(name = "don_gia_cho_thue")
    private int donGiaChoThue;

    // Constructor có tham số
    public CayCanh(String tenCayCanh, String loaiCayCanh, int donGiaChoThue) {
        this.tenCayCanh = tenCayCanh;
        this.loaiCayCanh = loaiCayCanh;
        this.donGiaChoThue = donGiaChoThue;
    }

    // Constructor mặc định
    public CayCanh() {}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenCayCanh() {
        return tenCayCanh;
    }

    public void setTenCayCanh(String tenCayCanh) {
        this.tenCayCanh = tenCayCanh;
    }

    public String getLoaiCayCanh() {
        return loaiCayCanh;
    }

    public void setLoaiCayCanh(String loaiCayCanh) {
        this.loaiCayCanh = loaiCayCanh;
    }

    public int getDonGiaChoThue() {
        return donGiaChoThue;
    }

    public void setDonGiaChoThue(int donGiaChoThue) {
        this.donGiaChoThue = donGiaChoThue;
    }

    @Override
    public String toString() {
        return "CayCanh{" +
                "id=" + id +
                ", tenCayCanh='" + tenCayCanh + '\'' +
                ", loaiCayCanh='" + loaiCayCanh + '\'' +
                ", donGiaChoThue=" + donGiaChoThue +
                '}';
    }
}