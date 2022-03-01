package com.feefo.technicalAssesment.note.exception.note;

public class NoteNotFoundException extends RuntimeException {
    
    public NoteNotFoundException(Long id) {
        super("Could not find note " + id);
    }

}