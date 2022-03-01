package com.feefo.technicalAssesment.note.repository;

import com.feefo.technicalAssesment.note.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}