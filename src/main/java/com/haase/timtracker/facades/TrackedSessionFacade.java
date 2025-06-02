package com.haase.timtracker.facades;

import com.haase.timtracker.entities.TrackedSession;
import com.haase.timtracker.services.TrackedSessionService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Facade Class to interact with Service classes and hide internal Structure
 * @author Tim Haase
 */
@Component
public class TrackedSessionFacade {

    private final TrackedSessionService service;

    public TrackedSessionFacade(TrackedSessionService service) {
        this.service = service;
    }

    /**
     * Creates or updates a TrackedSession.
     * @param session the session to save
     * @return the persisted session
     */
    public TrackedSession createSession(TrackedSession session) {
        return service.saveSession(session);
    }

    /**
     * Retrieves all tracked sessions.
     * @return list of sessions
     */
    public List<TrackedSession> getAllSessions() {
        return service.getAllSessions();
    }

    /**
     * Retrieves a specific session by ID.
     * @param id the session ID
     * @return the found session, if any
     */
    public Optional<TrackedSession> getSessionById(Long id) {
        return service.getSessionById(id);
    }

    /**
     * Deletes a session by ID.
     * @param id ID of the session
     */
    public void deleteSession(Long id) {
        service.deleteSession(id);
    }
}
