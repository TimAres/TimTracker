package com.haase.timtracker.services;

import com.haase.timtracker.entities.TrackedSession;
import com.haase.timtracker.repositories.TrackedSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class responsible for business logic related to TrackedSession.
 * Acts as a layer between the controller/facade and the repository.
 * @author Tim Haase
 */
@Service
public class TrackedSessionService {

    private final TrackedSessionRepository repository;

    /**
     * Constructor-based dependency injection for the repository.
     * @param repository the repository used to access the database
     */
    public TrackedSessionService(TrackedSessionRepository repository) {
        this.repository = repository;
    }

    /**
     * Saves a new or existing TrackedSession entity.
     * @param session the session to save
     * @return the saved session
     */
    public TrackedSession saveSession(TrackedSession session) {
        return repository.save(session);
    }

    /**
     * Retrieves a TrackedSession by its ID.
     * @param id the ID of the session
     * @return an Optional containing the session, or empty if not found
     */
    public Optional<TrackedSession> getSessionById(Long id) {
        return repository.findById(id);
    }

    /**
     * Retrieves all tracked sessions from the database.
     * @return a list of all sessions
     */
    public List<TrackedSession> getAllSessions() {
        return repository.findAll();
    }

    /**
     * Deletes a session by its ID.
     * @param id the ID of the session to delete
     */
    public void deleteSession(Long id) {
        repository.deleteById(id);
    }

}
