// Quy tắc đặt tên package là snake_case
package org.example.configs;

import org.example.Person;
import org.example.service.CustomerService;
import org.example.service.OrderService;
import org.example.service.impl.CustomerServiceImpl;
import org.example.service.impl.OrderServiceImpl;
import org.springframework.context.annotation.Bean;

// Quy tắc đặt tên class -> PascalCase
public class AppConfiguration {
    @Bean
    // Bean có tên nhưng nếu không ghi sẽ lấy mặc định tên hàm
    public Person fullStack(){
        // Quy tắc đặt tên biến camelCase
        Person doKhacQuyen = new Person();
        doKhacQuyen.setId(1);
        doKhacQuyen.setName("Đỗ Khắc Quyền");
        doKhacQuyen.setMajor("Full snack");
        return doKhacQuyen;
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl();
    }
    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl();
    }
}
