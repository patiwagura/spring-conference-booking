package com.cobiztech.conference_booking.repositories;

import com.cobiztech.conference_booking.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA Repository - provides lots of built-in functionality we can inherit.
public interface SessionRepository extends
        JpaRepository<Session, Long> {
}
