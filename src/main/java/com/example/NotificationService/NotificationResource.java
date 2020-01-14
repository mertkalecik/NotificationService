package com.example.NotificationService;

import com.example.NotificationService.interfaces.NotificationRepository;
import com.example.NotificationService.model.ServerLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("rest/notification")
public class NotificationResource {

    private NotificationRepository repository;

    public NotificationResource(NotificationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/add/{id}/{message}")
    public ServerLog add(@PathVariable("id") final String id,
                         @PathVariable("message") final  String message) {

        Random random = new Random();
        String messageId = random.nextInt()+"";
        repository.save(new ServerLog(messageId, id, message));

        System.out.println("New notification is arrived: " + message);
        return repository.findNotificationById(messageId);
    }

    @GetMapping("/all")
    public Map<String, ServerLog> gellAll() {
        return repository.getAll();
    }
}
