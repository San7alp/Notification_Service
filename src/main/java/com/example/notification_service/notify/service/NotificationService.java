package com.example.notification_service.notify.service;

import com.example.notification_service.notify.Notification;
import com.example.notification_service.notify.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public void sendNotificationToAllUsers(String message, String type) {
        for (long userId = 1; userId <= 5; userId++) {
            Notification notification = new Notification();
            notification.setUserId(userId);
            notification.setMessage(message);
            notification.setTimestamp(LocalDateTime.now());
            notification.setType(type); // Set type
            repository.save(notification);
        }
    }


    public List<Notification> getNotificationsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
