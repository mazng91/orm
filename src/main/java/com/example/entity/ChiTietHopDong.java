package com.example.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CHI_TIET_HOP_DONG")
public class ChiTietHopDong {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ma_hop_dong_cho_thue")
    private HopDongChoThue hopDongChoThue;

    @ManyToOne
    @JoinColumn(name = "ma_cay_canh")
    private CayCanh cayCanh;

    @Column(name = "so_luong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "ma_loai_dich_vu")
    private LoaiDichVu loaiDichVu;

    @Column(name = "ngay_bat_dau_cho_thue")
    private Date ngayBatDauChoThue;

    @Column(name = "ngay_ket_thuc_cho_thue")
    private Date ngayKetThucChoThue;

    // Constructor có tham số
    public ChiTietHopDong(HopDongChoThue hopDongChoThue, CayCanh cayCanh, Integer soLuong, LoaiDichVu loaiDichVu, Date ngayBatDauChoThue, Date ngayKetThucChoThue) {
        this.hopDongChoThue = hopDongChoThue;
        this.cayCanh = cayCanh;
        this.soLuong = soLuong;
        this.loaiDichVu = loaiDichVu;
        this.ngayBatDauChoThue = ngayBatDauChoThue;
        this.ngayKetThucChoThue = ngayKetThucChoThue;
    }

    // Constructor mặc định
    public ChiTietHopDong() {}

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HopDongChoThue getHopDongChoThue() {
        return hopDongChoThue;
    }

    public void setHopDongChoThue(HopDongChoThue hopDongChoThue) {
        this.hopDongChoThue = hopDongChoThue;
    }

    public CayCanh getCayCanh() {
        return cayCanh;
    }

    public void setCayCanh(CayCanh cayCanh) {
        this.cayCanh = cayCanh;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public LoaiDichVu getLoaiDichVu() {
        return loaiDichVu;
    }

    public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
        this.loaiDichVu = loaiDichVu;
    }

    public Date getNgayBatDauChoThue() {
        return ngayBatDauChoThue;
    }

    public void setNgayBatDauChoThue(Date ngayBatDauChoThue) {
        this.ngayBatDauChoThue = ngayBatDauChoThue;
    }

    public Date getNgayKetThucChoThue() {
        return ngayKetThucChoThue;
    }

    public void setNgayKetThucChoThue(Date ngayKetThucChoThue) {
        this.ngayKetThucChoThue = ngayKetThucChoThue;
    }

    @Override
    public String toString() {
        return "ChiTietHopDong{" +
                "id=" + id +
                ", hopDongChoThue=" + hopDongChoThue +
                ", cayCanh=" + cayCanh +
                ", soLuong=" + soLuong +
                ", loaiDichVu=" + loaiDichVu +
                ", ngayBatDauChoThue=" + ngayBatDauChoThue +
                ", ngayKetThucChoThue=" + ngayKetThucChoThue +
                '}';
    }
}