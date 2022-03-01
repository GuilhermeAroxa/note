package com.feefo.technicalAssesment.note.controller;

import java.util.Calendar;
import java.util.List;

import com.feefo.technicalAssesment.note.exception.note.NoteNotFoundException;
import com.feefo.technicalAssesment.note.model.Note;
import com.feefo.technicalAssesment.note.repository.NoteRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Notes")
@CrossOrigin(maxAge = 3600)
@RestController
class NoteController {

    private final NoteRepository repository;

    NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @ApiOperation("Get all notes")
    @GetMapping("/notes")
    public List<Note> getAll() {
        return repository.findAll();
    }

    @ApiOperation("Create a note")
    @PostMapping("/notes")
    public Note createNote(@RequestBody Note note) {
        return repository.save(note);
    }

    @ApiOperation("Get note by ID")
    @GetMapping("/notes/{id}")
    public Note getNote(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @ApiOperation("Edit Note")
    @PutMapping("/notes/{id}")
    public Note changeNote(@RequestBody Note note, @PathVariable Long id) {
        return repository.findById(id)
                .map(noteFound -> {
                    noteFound.setTitle(note.getTitle());
                    noteFound.setBody(note.getBody());
                    noteFound.setUpdatedAt(Calendar.getInstance());
                    return repository.save(noteFound);
                })
                .orElseGet(() -> {
                    return repository.save(note);
                });
    }

    @ApiOperation("Delete Note")
    @DeleteMapping("/notes/{id}")
    public void deleteNote(@PathVariable Long id) {
        repository.deleteById(id);
    }
}