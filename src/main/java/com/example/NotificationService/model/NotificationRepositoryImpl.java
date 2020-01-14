package com.example.NotificationService.model;

import com.example.NotificationService.interfaces.NotificationRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private RedisTemplate<String, ServerLog> redisTemplate;
    private HashOperations hashOperations;

    public NotificationRepositoryImpl(RedisTemplate<String, ServerLog> redisTemplate) {
        this.redisTemplate = redisTemplate;

        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(ServerLog log) {

        hashOperations.put("NOTIF", log.getId(), log);
    }

    @Override
    public Map<String, ServerLog> getAll() {
        return hashOperations.entries("NOTIF");
    }

    @Override
    public ServerLog findNotificationById(String id) {
        return (ServerLog) hashOperations.get("NOTIF", id);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete("NOTIF", id);
    }
}
