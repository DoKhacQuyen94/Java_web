package org.example.btth;

import org.springframework.stereotype.Component;

@Component
public class NormalNotify implements Notification {
    @Override
    public void sendNotification(String userName, String message) {
        System.out.println("[ Volume ]: " + userName +
                                    " | "+ " Message : " + message);
    }

}
