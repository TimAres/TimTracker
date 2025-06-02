package com.haase.timtracker;

import com.haase.timtracker.entities.TrackedSession;
import com.haase.timtracker.facades.TrackedSessionFacade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TrackedSessionFacadeTest {

    @Autowired
    private TrackedSessionFacade facade;

    @Test
    void testCreateReadDeleteSession() {
        TrackedSession session = TrackedSession.builder()
                .sessionTitel("Test Session")
                .sessionStartDate(LocalDateTime.now())
                .sessionEndDate(LocalDateTime.now().plusHours(1))
                .build();


        // Save session
        TrackedSession savedSession = facade.createSession(session);
        assertThat(savedSession.getId()).isNotNull();

        Long sessionId = savedSession.getId();

        // Read session
        Optional<TrackedSession> fetchedSession = facade.getSessionById(sessionId);
        assertThat(fetchedSession).isPresent();
        assertThat(fetchedSession.get().getSessionTitel()).isEqualTo("Test Session");

        // Delete session
        facade.deleteSession(sessionId);

        // Verify deletion
        Optional<TrackedSession> deletedSession = facade.getSessionById(sessionId);
        assertThat(deletedSession).isNotPresent();
    }
}
