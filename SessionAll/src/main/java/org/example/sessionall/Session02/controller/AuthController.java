package org.example.sessionall.Session02.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String showLoginPage(HttpSession session) {
        // Nếu đã đăng nhập thì không cho vào trang login nữa
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/orders";
        }
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               HttpSession session,
                               Model model) { // Model đại diện cho Request Scope

        // Hardcode xác thực
        if (("admin".equals(username) && "admin123".equals(password)) ||
                ("staff".equals(username) && "staff123".equals(password))) {

            // Đăng nhập đúng: Lưu vào Session Scope
            session.setAttribute("loggedUser", username);
            session.setAttribute("role", username.equals("admin") ? "Quản trị viên" : "Nhân viên");

            return "redirect:/orders"; // Redirect để đổi URL
        }

        // Đăng nhập sai: Đẩy lỗi vào Request Scope (Model) và forward lại trang login
        model.addAttribute("errorMsg", "Sai tên đăng nhập hoặc mật khẩu!");
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // Hủy session hiện tại
        session.invalidate();
        return "redirect:/login";
    }
}
