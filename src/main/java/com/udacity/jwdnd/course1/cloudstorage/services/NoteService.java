package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {

    private final NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

    public List<Note> getNoteListByUserId(Integer userId) {
        return noteMapper.findAllNotesByUserId(userId);
    }

    public Note getNoteById(Integer noteId) {
        return this.noteMapper.findNoteById(noteId);
    }

    public Note getNoteByTitleAndDescription(String title, String description) {
        return this.noteMapper.findNoteByTitleAndDescription(title, description);
    }


    public void createNoteByUserId(Note note, Integer userId) {
        note.setUserId(userId);
        this.noteMapper.save(note);
    }

    public void updateNoteByUserId(Integer id, String title, String description, Integer userId) {
        this.noteMapper.update(id, title, description, userId);
    }

    public void deleteNoteByIdAndUserId(Integer id, Integer userId) {
        this.noteMapper.delete(id, userId);
    }
}