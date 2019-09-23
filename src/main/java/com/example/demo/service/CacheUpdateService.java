package com.example.demo.service;

import com.example.demo.dao.CacheAuditService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CacheUpdateService {

    private static AtomicLong count = new AtomicLong(0);

    private Random random = new Random();

    private final CacheAuditService cacheAuditService;

    public CacheUpdateService(CacheAuditService cacheAuditService) {
        this.cacheAuditService = cacheAuditService;
    }

    @Scheduled(fixedRate = 500)
    public void insertNewCacheRow() {

        if (random.nextInt(10) > 6) {
            LocalDateTime updated = LocalDateTime.now();
            cacheAuditService.addCacheRow("NEW-" + count.incrementAndGet(), updated);
            System.out.println(">>>>>>>> " + count.get());
        }
    }

    @Scheduled(fixedRate = 1000)
    public void removeOldCacheRow() {

        cacheAuditService.clearCache(10);

    }

}
