package com.pluralsight.conferencedemo.controlers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import com.pluralsight.conferencedemo.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionController {

    @Autowired
    SessionService sessionService;


    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.getAllSessions();
    }

    @GetMapping("/{id}")
    public Session getSessionById(@PathVariable Long id) {
        return sessionService.getSession(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Session createSession(@RequestBody Session session) {
        return sessionService.addSession(session);
    }

    @PutMapping("/{id}")
    public void updateSession(@PathVariable Long id, @RequestBody Session session) {
        sessionService.updateSession(id, session);
    }

    @DeleteMapping("/{id}")
    public void deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

}
