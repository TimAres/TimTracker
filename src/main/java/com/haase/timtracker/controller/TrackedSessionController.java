package com.haase.timtracker.controller;

import com.haase.timtracker.entities.TrackedSession;
import com.haase.timtracker.facades.TrackedSessionFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for TrackedSession resources.
 * Handles incoming HTTP requests and delegates to the facade layer.
 */
@RestController
@RequestMapping("/api/sessions")
public class TrackedSessionController {

    private final TrackedSessionFacade facade;

    public TrackedSessionController(TrackedSessionFacade facade) {
        this.facade = facade;
    }

    @PostMapping
    public ResponseEntity<TrackedSession> createSession(@RequestBody TrackedSession session) {
        TrackedSession saved = facade.createSession(session);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<TrackedSession>> getAllSessions() {
        return ResponseEntity.ok(facade.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackedSession> getSessionById(@PathVariable Long id) {
        Optional<TrackedSession> session = facade.getSessionById(id);
        return session.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        facade.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
