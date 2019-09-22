package com.example.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cache_audit")
public class CacheAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "cache_type")
    private String cacheType;

    @Column(name = "updated")
    private LocalDateTime updated;

    @Column(name = "last_update")
    private LocalDateTime lasUpdate;

    public CacheAuditEntity() {
    }

    public CacheAuditEntity(String cacheType, LocalDateTime updated) {
        this.cacheType = cacheType;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCacheType() {
        return cacheType;
    }

    public void setCacheType(String cacheType) {
        this.cacheType = cacheType;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getLasUpdate() {
        return lasUpdate;
    }

    public void setLasUpdate(LocalDateTime lasUpdate) {
        this.lasUpdate = lasUpdate;
    }
}
