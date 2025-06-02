package com.haase.timtracker.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.Temporal;


/**
 * Entity to track a work session.
 * Start and end are stored; duration can be computed or stored.
 * @author Tim Haase
 */

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class TrackedSession {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tracked_session_seq")
    @SequenceGenerator(name = "tracked_session_seq", sequenceName = "tracked_session_seq", allocationSize = 1)
    private Long id;

    private String sessionTitel;

    private LocalDateTime sessionStartDate;

    private LocalDateTime sessionEndDate;

    private int sessionDuration;



     @Transient
     public int getComputedDuration() {
        return (int) Duration.between(sessionStartDate,  sessionEndDate).toMinutes();
     }

}
