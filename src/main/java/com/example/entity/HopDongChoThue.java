package com.example.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import com.example.entity.*;
@Entity
@Table(name = "HOP_DONG_CHO_THUE")
public class HopDongChoThue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "idKhachHang")
    private KhachHang khachHang;

    @Column(name = "soTienDatCoc")
    private double soTienDatCoc;

    @Column(name = "tienGiamGia")
    private double tienGiamGia;

    @Column(name = "tienThanhToan")
    private double tienThanhToan;

    @Column(name = "ngayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "phuongThucGiaoDich")
    private String phuongThucGiaoDich;

    @Column(name = "trangThai")
    private String trangThai;

    @OneToMany(mappedBy = "hopDongChoThue")
    private Set<ChiTietHopDong> chiTietHopDongs;

    // Constructors, getters and setters
    public HopDongChoThue() {
    }

    public HopDongChoThue(KhachHang khachHang, double soTienDatCoc, double tienGiamGia, double tienThanhToan, Date ngayThanhToan, String phuongThucGiaoDich, String trangThai) {
        this.khachHang = khachHang;
        this.soTienDatCoc = soTienDatCoc;
        this.tienGiamGia = tienGiamGia;
        this.tienThanhToan = tienThanhToan;
        this.ngayThanhToan = ngayThanhToan;
        this.phuongThucGiaoDich = phuongThucGiaoDich;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public double getSoTienDatCoc() {
        return soTienDatCoc;
    }

    public void setSoTienDatCoc(double soTienDatCoc) {
        this.soTienDatCoc = soTienDatCoc;
    }

    public double getTienGiamGia() {
        return tienGiamGia;
    }

    public void setTienGiamGia(double tienGiamGia) {
        this.tienGiamGia = tienGiamGia;
    }

    public double getTienThanhToan() {
        return tienThanhToan;
    }

    public void setTienThanhToan(double tienThanhToan) {
        this.tienThanhToan = tienThanhToan;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getPhuongThucGiaoDich() {
        return phuongThucGiaoDich;
    }

    public void setPhuongThucGiaoDich(String phuongThucGiaoDich) {
        this.phuongThucGiaoDich = phuongThucGiaoDich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Set<ChiTietHopDong> getChiTietHopDongs() {
        return chiTietHopDongs;
    }

    public void setChiTietHopDongs(Set<ChiTietHopDong> chiTietHopDongs) {
        this.chiTietHopDongs = chiTietHopDongs;
    }
// Getters and setters for all attributes
    // ...
}