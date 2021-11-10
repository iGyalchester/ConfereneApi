package com.pluralsight.conferencedemo.models;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long speakers_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    @Lob//helps dealt with large objects
    @Type(type="org.hibernate.type.BinaryType")//deal with binary data. without it, it will be stored as a string
    private byte [] speaker_photo;

    @ManyToMany(mappedBy = "speakers")
    private java.util.List<Session> sessions;
    public Speaker() {

    }

    public byte[] getSpeaker_photo() {
        return speaker_photo;
    }

    public void setSpeaker_photo(byte[] speaker_photo) {
        this.speaker_photo = speaker_photo;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public Long getSpeakers_id() {
        return speakers_id;
    }

    public void setSpeakers_id(Long speakers_id) {
        this.speakers_id = speakers_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSpeaker_bio() {
        return speaker_bio;
    }

    public void setSpeaker_bio(String speaker_bio) {
        this.speaker_bio = speaker_bio;
    }
}
