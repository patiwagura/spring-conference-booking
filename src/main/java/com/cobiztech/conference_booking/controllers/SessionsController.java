package com.cobiztech.conference_booking.controllers;

import com.cobiztech.conference_booking.models.Session;
import com.cobiztech.conference_booking.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Lob;
import java.util.List;
import java.util.Optional;


/**
 * Controllers - handle api endpoints e.g /sessions
 *
 * @RestController - this controller will respond to HTTP-requests as Json-REST-endpoints.
 * @RequestMapping - tells Router how HTTP-URL-PATH looks like e.g /api/v1/sessions.
 */
@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

    // Dependency-Injection - SessionRepository instance.
    @Autowired
    private SessionRepository sessionRepository;

    // get all sessions.
    @GetMapping
    public List<Session> list() {
        return sessionRepository.findAll();
    }

    // get session by Id.
    // HTTP-URL-PATH = /api/v1/sessions/{id}
    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        //return sessionRepository.getOne(id);
        return ((Optional<Session>) sessionRepository.findById(id)).get();
    }

    // @RequestBody - serialize Json-data {"id":1, "session_name":"Health topic"} into Java-Object(id, session_name).
    @PostMapping
    // @ResponseStatus(HttpStatus.CREATED) // 201 - response code created.
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    // delete by Id.
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also need to check for children records before deleting.
        sessionRepository.deleteById(id);
    }

    // update
    // @PutMapping
    // @RequestMapping("{id}")
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        // PUT request - expect all class-attributes to be passed along in the Request-Body.
        // PATCH request - only class-attributes with new-data are passed along in Request-Body.
        Session existingSession = ((Optional<Session>) sessionRepository.findById(id)).get();
        // copy object data & ignore session_id - which is the primary key.
        BeanUtils.copyProperties(session, existingSession, "session_id");
        return sessionRepository.saveAndFlush(existingSession);
    }

}
