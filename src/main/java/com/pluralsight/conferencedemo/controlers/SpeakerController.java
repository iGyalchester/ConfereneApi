package com.pluralsight.conferencedemo.controlers;


import com.pluralsight.conferencedemo.models.Session;
import com.pluralsight.conferencedemo.models.Speaker;
import com.pluralsight.conferencedemo.services.SpeakerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakerController {

    private SpeakerService speakerService;

    public SpeakerController(SpeakerService speakerService) {
        this.speakerService = speakerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public List<Speaker> getAllSpeakers() {
        return speakerService.getAllSpeakers();
    }

    @GetMapping("/{speakerId}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Speaker getSpeakerById(@PathVariable Long speakerId) {
        return speakerService.getSpeaker(speakerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Speaker addSpeaker(@RequestBody Speaker speaker) {
        return speakerService.addSpeaker(speaker);
    }

    @PutMapping("/{speakerId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateSpeaker(@PathVariable Long speakerId, @RequestBody Speaker speaker) {
        speakerService.updateSpeaker(speakerId, speaker);
    }

    @DeleteMapping("/{speakerId}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteSpeaker(@PathVariable Long speakerId) {
        speakerService.deleteSpeaker(speakerId);
    }

    //session for speaker??
    @GetMapping("/{speakerId}/sessions")
    public List<Session> getSessionsBySpeaker(@PathVariable Long speakerId) {
        return speakerService.getSessionsForSpeaker(speakerId);
    }
}
