package com.cobiztech.conference_booking.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity(name = "speakers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Speaker {

    //match class-attribute-names & db-column-names - allows JPA to auto-bind Database-data to object-instance.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long speaker_id;

    private String first_name;
    private String last_name;
    private String title;
    private String company;
    private String speaker_bio;

    // speaker-photo - in java (byte-array[]) is well suited to handle binary data.
    // @Lob - large Object annotation. (binary data can get big/large) helps JPA deal with big data.
    // @Type - helps hibernate(JPA implementation) to deal with the large-binary-data.
    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] speaker_photo;

    // (Many-to-Many relationship) Session - can have 1 or more speakers & vice-versa.
    // Relationship is mapped on Session - Entity.
    @ManyToMany(mappedBy = "speakers")
    //prevent - cyclic calling back to session.
    @JsonIgnore
    private List<Session> sessions;

    // default constructor.
    public Speaker() {
    }

    // getters & setters.

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

    public Long getSpeaker_id() {
        return speaker_id;
    }

    public void setSpeaker_id(Long speaker_id) {
        this.speaker_id = speaker_id;
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
