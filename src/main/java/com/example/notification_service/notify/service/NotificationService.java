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

    public void sendNotificationToAllUsers(String message) {
        // Dummy: Let's say user IDs are 1 to 5
        for (long userId = 1; userId <= 5; userId++) {
            Notification notification = new Notification();
            notification.setUserId(userId);
            notification.setMessage(message);
            notification.setTimestamp(LocalDateTime.now());
            repository.save(notification);
        }
    }

    public List<Notification> getNotificationsByUserId(Long userId) {
        return repository.findByUserId(userId);
    }
}
