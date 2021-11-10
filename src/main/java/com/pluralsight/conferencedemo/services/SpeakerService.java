package com.pluralsight.conferencedemo.services;

import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpeakerService {

    private SpeakerRepository speakerRepository;

    @Autowired
    public SpeakerService(SpeakerRepository speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    public List<Speaker> getAllSpeakers() {
        List <Speaker> speakers = new ArrayList<>();
        speakerRepository.findAll().forEach(speakers::add);
        return speakers;
    }

    public Speaker getSpeaker(Long speakerId) {
        return speakerRepository.findById(speakerId).orElse(null);
    }

    public Speaker addSpeaker(Speaker speaker) {
        return speakerRepository.save(speaker);
    }

    public void updateSpeaker(Long id, Speaker speaker) {
        speakerRepository.save(speaker);
    }

    public void deleteSpeaker(Long id) {
        speakerRepository.deleteById(id);
    }

    public List<Session> getSessionsForSpeaker(Long speakerId) {
        Speaker speaker = getSpeaker(speakerId);
        return speaker.getSessions();
    }
}
