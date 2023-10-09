package com.example.envers.config;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RevisionEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "audit_envers_info")
@RevisionEntity(UserRevisionListener.class)

public class CustomRevisionEntity extends DefaultRevisionEntity {

    @Column(name = "username")
    private String username;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @NotAudited
    private Instant createdDate = Instant.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private Instant lastModifiedDate = Instant.now();

    @Column(name = "uuid", updatable = false, nullable = false, unique = true)
    private UUID uuid = UUID.randomUUID();

}