package org.example.btth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccountManagement {
    private Map<String,Double> persion = new HashMap<>();
    @Autowired
    private NormalNotify notify;
    @Autowired
    private VipNotify notifyVip;

    public AccountManagement(Map<String, Double> persion) {
        this.persion = persion;
    }

    public void checkYourComputer(String userName, String area){
        if(userName == null || userName.isEmpty()){
            System.out.println("[ERROR]: Username is null or empty");
            return;
        }
        if(!persion.containsKey(userName)){
            System.out.println("[ERROR]: User doesn't exist");
            return;
        }
        // kiểm tra tiền
        double money = persion.get(userName);
        if(money<0){
            System.out.println("[ERROR]: Không đủ tiền để chơi game");
            return;
        }
        if(money<5000){
            if(area.equals("VIP")){
                // khu vực vip cần yên lặng
                notifyVip.sendNotification(userName,"Anh có cần em nạp tiền hộ không ạ");
            }else {
                // khu vực lỏ cần âm thanh
                notify.sendNotification(userName,"Sắp hết tiền rồi bạn êiiiiii!");
            }
        }
    }
}
