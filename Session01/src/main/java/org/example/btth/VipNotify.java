package org.example.btth;

import org.springframework.stereotype.Component;

@Component
public class VipNotify  implements Notification {
    @Override
    public void sendNotification(String userName, String message) {
        System.out.println("[ PopUp ]: "+ userName + " | "+ " Message : " + message);
    }
}
