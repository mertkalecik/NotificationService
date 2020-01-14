package com.example.NotificationService.interfaces;

import com.example.NotificationService.model.ServerLog;

import java.util.List;
import java.util.Map;

public interface NotificationRepository {

    void save(ServerLog log);
    Map<String, ServerLog> getAll();
    ServerLog findNotificationById(String id);
    void delete(String id);
}
