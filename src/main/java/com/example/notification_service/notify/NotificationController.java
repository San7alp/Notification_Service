package com.example.notification_service.notify;

import com.example.notification_service.notify.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> sendNotification(@RequestBody Map<String, String> body) {
        String message = body.get("message");
        service.sendNotificationToAllUsers(message);
        return ResponseEntity.ok("Notification sent to all users.");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Notification>> getUserNotifications(@PathVariable Long id) {
        return ResponseEntity.ok(service.getNotificationsByUserId(id));
    }
}
