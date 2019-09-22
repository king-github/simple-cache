package com.example.demo.repository;

import com.example.demo.entity.CacheAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface CacheAuditRepository extends JpaRepository<CacheAuditEntity, Long> {


    @Modifying
    @Transactional
    @Query("DELETE FROM CacheAuditEntity ca WHERE ca.lasUpdate < :date")
    int removeOlderThan(@Param("date") LocalDateTime date);

}
