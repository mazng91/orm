package com.example;

import com.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        // Tạo SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(CayCanh.class)
                .addAnnotatedClass(LoaiDichVu.class)
                .addAnnotatedClass(ChiTietHopDong.class)
                .addAnnotatedClass(HopDongChoThue.class)
                .addAnnotatedClass(KhachHang.class)
                .buildSessionFactory();

        // Tạo Session
        Session session = factory.getCurrentSession();

        try {
            // Bắt đầu transaction
            session.beginTransaction();

            // Tạo dữ liệu cho bảng CAY_CANH
            CayCanh cayCanh1 = new CayCanh("Trúc mây", "Cây cảnh nội thất", 100000);
            CayCanh cayCanh2 = new CayCanh("Kim ngân", "Cây cảnh phong thủy", 150000);
            CayCanh cayCanh3 = new CayCanh("Mai Tứ quý", "Cây cảnh sân vườn", 200000);
            CayCanh cayCanh4 = new CayCanh("Hoa Anh đào", "Cây cảnh quý hiếm", 500000);
            CayCanh cayCanh5 = new CayCanh("Trúc mây", "Cây cảnh nội thất", 100000);
            CayCanh cayCanh6 = new CayCanh("Kim ngân", "Cây cảnh phong thủy", 150000);
            CayCanh cayCanh7 = new CayCanh("Mai Tứ quý", "Cây cảnh sân vườn", 200000);
            CayCanh cayCanh8 = new CayCanh("Hoa Anh đào", "Cây cảnh quý hiếm", 500000);
            session.save(cayCanh1);
            session.save(cayCanh2);
            session.save(cayCanh3);
            session.save(cayCanh4);
            session.save(cayCanh5);
            session.save(cayCanh6);
            session.save(cayCanh7);
            session.save(cayCanh8);

            // Tạo dữ liệu cho bảng LOAI_DICH_VU
            LoaiDichVu dichVu1 = new LoaiDichVu("Chăm hằng ngày", 50000);
            LoaiDichVu dichVu2 = new LoaiDichVu("Chăm hằng tuần", 200000);
            LoaiDichVu dichVu3 = new LoaiDichVu("Chăm hằng tháng", 500000);

            session.save(dichVu1);
            session.save(dichVu2);
            session.save(dichVu3);

            // Tạo dữ liệu cho bảng KHACH_HANG
            for (int i = 1; i <= 10; i++) {
                KhachHang khachHang = new KhachHang("Khách hàng " + i, (i % 2 == 0) ? "Nam" : "Nữ", new Date(), "Địa chỉ " + i, "012345678" + i);
                session.save(khachHang);
            }

            // Tạo dữ liệu cho bảng HOP_DONG_CHO_THUE
            HopDongChoThue hopDong1 = new HopDongChoThue(session.get(KhachHang.class, 1), 1000000, 0, 5000000, new Date(), "Tiền mặt", "Hoàn thành");
            HopDongChoThue hopDong2 = new HopDongChoThue(session.get(KhachHang.class, 2), 500000, 100000, 3000000, new Date(), "Chuyển khoản", "Đang thực hiện");

            session.save(hopDong1);
            session.save(hopDong2);


            Calendar calendar = Calendar.getInstance();
            Date ngayBatDau1 = calendar.getTime();
            calendar.add(Calendar.MONTH, 1); // Cộng thêm 1 tháng cho ngày kết thúc hiện tại
            Date ngayKetThuc1 = calendar.getTime();

            calendar.add(Calendar.MONTH, -3); // Trừ 3 tháng cho ngày bắt đầu quá khứ
            Date ngayBatDau2 = calendar.getTime();
            calendar.add(Calendar.MONTH, 1); // Cộng thêm 1 tháng cho ngày kết thúc quá khứ
            Date ngayKetThuc2 = calendar.getTime();

            ChiTietHopDong chiTiet1 = new ChiTietHopDong(hopDong1, cayCanh1, 2, dichVu1, ngayBatDau1, ngayKetThuc1);
            ChiTietHopDong chiTiet2 = new ChiTietHopDong(hopDong2, cayCanh2, 1, dichVu2, ngayBatDau2, ngayKetThuc2);
            ChiTietHopDong chiTiet3 = new ChiTietHopDong(hopDong1, cayCanh3, 3, dichVu3, ngayBatDau2, ngayKetThuc2);
            ChiTietHopDong chiTiet4 = new ChiTietHopDong(hopDong1, cayCanh4, 5, dichVu2, ngayBatDau1, ngayKetThuc1);
            session.save(chiTiet1);
            session.save(chiTiet2);
            session.save(chiTiet3);
            session.save(chiTiet4);

            // Commit transaction
            session.getTransaction().commit();

            // Kiểm tra hợp đồng
            ContractChecker.checkContracts();

        } finally {
            // Đóng SessionFactory
            factory.close();
        }
    }
}