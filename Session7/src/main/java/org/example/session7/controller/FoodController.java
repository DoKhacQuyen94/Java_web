package org.example.session7.controller;

import org.example.session7.models.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/merchant/food")
public class FoodController {

    private static List<Food> foodList = new ArrayList<>();
    private static final String UPLOAD_PATH = "C:\\Users\\DoKhacQuyen\\Documents\\JAVAWEb\\Session7\\src\\main\\resources\\";
    @GetMapping("/add")
    public String showAddForm(Model model) {
        // Chuẩn bị sẵn một object Food trống để bind vào form
        model.addAttribute("food", new Food());

        // Chuẩn bị danh sách categories cho dropdown
        List<String> categories = Arrays.asList("Khai vị", "Món chính", "Đồ uống", "Tráng miệng");
        model.addAttribute("categories", categories);

        return "baitap03"; // Trả về file food-add.html
    }
    @PostMapping("/add")
    public String addFood(@ModelAttribute("food") Food food,
                          @RequestParam("image") MultipartFile file,
                          RedirectAttributes redirectAttributes,
                          Model model) {
        // 1. Kiểm tra ảnh trống
        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng đính kèm hình ảnh món ăn!");
            return "food-add";
        }
        // 2. Kiểm tra định dạng file (Chỉ image/*)
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image/")) {
            model.addAttribute("error", "Định dạng file không hợp lệ (chỉ chấp nhận ảnh)!");
            return "food-add";
        }
        // 3. Kiểm tra giá tiền (>= 0)
        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá tiền không được phép âm!");
            return "food-add";
        }
//        try {
//            // Kiểm tra và tạo thư mục nếu chưa tồn tại
//            File uploadDir = new File(UPLOAD_PATH);
//            if (!uploadDir.exists()) uploadDir.mkdirs();
//            // Lưu file vật lý
//            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//            File destination = new File(UPLOAD_PATH + fileName);
//            file.transferTo(destination);
//            // Cập nhật thông tin và lưu vào List tĩnh
//            food.setImageUrl(destination.getAbsolutePath());
//            foodList.add(food);
//            // Xác nhận console
//            System.out.println("=== THÊM MÓN ĂN THÀNH CÔNG ===");
//            System.out.println("Tên món: " + food.getName());
//            System.out.println("Giá: " + food.getPrice());
//            System.out.println("Đường dẫn ảnh: " + food.getImageUrl());
//            System.out.println("Tổng số món hiện có: " + foodList.size());
//            return "redirect:/merchant/food/detail";
//        } catch (IOException e) {
//            e.printStackTrace();
//            model.addAttribute("error", "Lỗi trong quá trình lưu file!");
//            return "baitap03";
//        }
        try {
            File uploadDir = new File(UPLOAD_PATH);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
            File destination = new File(uploadDir, uniqueFileName);
            file.transferTo(destination);
            food.setImageUrl(destination.getAbsolutePath());
            foodList.add(food);
            redirectAttributes.addFlashAttribute("successMsg", "Thêm món ăn thành công!");
            redirectAttributes.addFlashAttribute("newFood", food);
            return "redirect:/merchant/food/detail";
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi lưu file: " + e.getMessage());
            return "baitap03";
        }
    }
    @GetMapping("/detail")
    public String showDetail() {
        return "baitap04";
    }
}