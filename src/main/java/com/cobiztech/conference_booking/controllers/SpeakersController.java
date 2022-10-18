package com.cobiztech.conference_booking.controllers;

import com.cobiztech.conference_booking.models.Speaker;
import com.cobiztech.conference_booking.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Controllers - handle API endpoints e.g /speakers.
 *
 * @RestController - controller will respond to HTTP-Requests as Json-REST-endpoints
 * @RequestMapping - specifies HTTP-URL-PATH to resource eg /api/v1/speakers.
 */
@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

    // Dependency-Injection - SpeakerRepository instance.
    @Autowired
    private SpeakerRepository speakerRepository;

    // get all speakers.
    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    // get speaker-ById
    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        // type-cast Optional<Speaker> to Speaker object-instance.
        return ((Optional<Speaker>) speakerRepository.findById(id)).get();
    }

    // Create
    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    // Delete by-Id
    //@DeleteMapping
    //@RequestMapping("{id}")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        // Also need to check for children-records before deleting.
        speakerRepository.deleteById(id);
    }

    // Update
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody final Speaker speaker) {
        // PUT Request - expects all class-attributes to be passed along in Request-Body.
        // PATCH Request - only class-attributes with new-data are required.
        Speaker existingSpeaker = ((Optional<Speaker>) speakerRepository.findById(id)).get();
        // Copy object-data & ignore some-fields e.g session_id - which is the primary key.
        BeanUtils.copyProperties(speaker, existingSpeaker, "speaker_id");
        return speakerRepository.saveAndFlush(existingSpeaker);
    }
}
