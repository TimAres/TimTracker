package com.haase.timtracker.repositories;

import com.haase.timtracker.entities.TrackedSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackedSessionRepository extends JpaRepository<TrackedSession, Long> {
}
