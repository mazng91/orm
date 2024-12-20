package com.example;

import com.example.entity.ChiTietHopDong;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ContractChecker {

    public static void checkContracts() {
        // Tạo SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ChiTietHopDong.class) // Thêm dòng này
                .buildSessionFactory();

        // Tạo Session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            // Tạo câu truy vấn HQL
            String hql = "FROM ChiTietHopDong";
            Query query = session.createQuery(hql); // Không cần truyền class type nữa

            // Lấy danh sách ChiTietHopDong
            List<ChiTietHopDong> chiTietHopDongs = query.getResultList();

            // Kiểm tra ngày kết thúc cho thuê
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -7); // Trừ đi 7 ngày
            Date ngayHetHan = calendar.getTime();

            boolean hasContract = false; // Biến để kiểm tra xem có hợp đồng nào thỏa mãn hay không

            System.out.println("Danh sách hợp đồng sắp hết hạn hoặc quá hạn 1 tuần:");

            for (ChiTietHopDong chiTiet : chiTietHopDongs) {
                if (chiTiet.getNgayKetThucChoThue().before(ngayHetHan)) {
                    System.out.println(chiTiet);
                    hasContract = true;
                }
            }

            if (!hasContract) {
                System.out.println("Không có hợp đồng nào gần hết hạn hoặc hết hạn.");
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }
    }
}