package com.example.demo.dao;

import java.time.LocalDateTime;

public interface CacheAuditService {
    void clearCache(int delayInSeconds);

    void addCacheRow(String cacheType, LocalDateTime updated);
}
