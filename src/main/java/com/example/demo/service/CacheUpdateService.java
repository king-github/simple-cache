package com.example.demo.service;

import com.example.demo.dao.CacheAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class CacheUpdateService {

    private static AtomicLong count = new AtomicLong(0);

    @Autowired
    private CacheAuditService cacheAuditService;

    @Scheduled(fixedRate = 1000)
    public void insertNewCacheRow() {

        LocalDateTime updated = LocalDateTime.now();
        cacheAuditService.addCacheRow("NEW-" + count.incrementAndGet(), updated);
        System.out.println(">>>>>>>> " + count.get());

    }

    @Scheduled(fixedRate = 1000)
    public void removeOldCacheRow() {

        cacheAuditService.clearCache(10);

    }

}
