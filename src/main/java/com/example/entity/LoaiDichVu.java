package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "LOAI_DICH_VU")
public class LoaiDichVu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "gia_dich_vu")
    private Double giaDichVu;

    public LoaiDichVu(String moTa, int giaDichVu) {
        this.moTa = moTa;
        this.giaDichVu = (double) giaDichVu;
    }
    // Constructor mặc định
    public LoaiDichVu() {}
    // Getters and setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Double getGiaDichVu() {
        return giaDichVu;
    }

    public void setGiaDichVu(Double giaDichVu) {
        this.giaDichVu = giaDichVu;
    }


}