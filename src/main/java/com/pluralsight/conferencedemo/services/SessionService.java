package com.pluralsight.conferencedemo.services;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> getAllSessions() {
        List <Session> sessions = new ArrayList<>();
        sessionRepository.findAll().forEach(sessions::add);
        return sessions;
    }

    public Session getSession(Long id) {
        return sessionRepository.findById(id).orElse(null);
    }

    public Session addSession(Session session) {
        return sessionRepository.save(session);
    }

    public void updateSession(Long id, Session session) {
        sessionRepository.save(session);
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}
