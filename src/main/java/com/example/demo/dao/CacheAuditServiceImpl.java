package com.example.demo.dao;

import com.example.demo.entity.CacheAuditEntity;
import com.example.demo.repository.CacheAuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class CacheAuditServiceImpl implements CacheAuditService {

    @Autowired
    private CacheAuditRepository cacheAuditRepository;


    @Override
    public void clearCache(int delayInSeconds) {

        cacheAuditRepository.removeOlderThan(LocalDateTime.now().minusSeconds(delayInSeconds));
    //    cacheAuditRepository.deleteAll();
        cacheAuditRepository.findAll().forEach(cacheAuditEntity -> {

            System.err.println(cacheAuditEntity.getCacheType()+" "+cacheAuditEntity.getLasUpdate());
        });
    }


    @Override
    @Transactional
    public void addCacheRow(String cacheType, LocalDateTime updated) {

        cacheAuditRepository.save(new CacheAuditEntity(cacheType, updated));

    }

}
