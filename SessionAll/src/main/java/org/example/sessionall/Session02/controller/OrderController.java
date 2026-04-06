package org.example.sessionall.Session02.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.example.sessionall.Session02.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class OrderController {

    @Autowired
    private ServletContext application; // Inject Application Scope

    @GetMapping("/orders")
    public String showOrders(HttpSession session, Model model) {
        // 1. Kiểm tra đăng nhập (Bẫy dữ liệu 1 & 5)
        if (session.getAttribute("loggedUser") == null) {
            return "redirect:/login";
        }

        // 2. Tạo danh sách đơn hàng (Lưu vào Request Scope qua Model)
        List<Order> orderList = Arrays.asList(
                new Order("ORD001", "Laptop Dell XPS", 25500000.0, new Date()),
                new Order("ORD002", "Chuột Logitech MX Master 3", 2200000.0, new Date()),
                new Order("ORD003", "Bàn phím cơ Keychron", 1800000.0, new Date())
        );
        model.addAttribute("orderList", orderList);

        // 3. Xử lý bộ đếm toàn cục chống Race Condition (Sử dụng AtomicInteger)
        // Double-checked locking pattern cho ServletContext
        AtomicInteger viewCount = (AtomicInteger) application.getAttribute("totalViewCount");
        if (viewCount == null) {
            synchronized (application) {
                viewCount = (AtomicInteger) application.getAttribute("totalViewCount");
                if (viewCount == null) {
                    viewCount = new AtomicInteger(0);
                    application.setAttribute("totalViewCount", viewCount);
                }
            }
        }

        // Tăng bộ đếm an toàn và không cần set lại vào attribute vì AtomicInteger tự cập nhật giá trị
        viewCount.incrementAndGet();

        return "orders";
    }
}