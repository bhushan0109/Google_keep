package com.finovate.service;

import com.finovate.dto.LabelDto;
import com.finovate.dto.NoteDto;
import com.finovate.dto.ReminderDto;
import com.finovate.model.Note;
import com.finovate.model.Response;

import java.util.List;

public interface NoteService {
    Response create(NoteDto noteDto, String token);
    Response update(NoteDto noteDto, String token, int noteId);
    Response delete(String token, int noteId);
    Object getNote(String token, int noteId);
    List<Note> getAllNotes(String token);
    Response archiveNote(String token, int noteId);
    Response pinNote(String token, int noteId);
    Response trashNote(String token, int noteId);
    Response addLabel(String token, int noteId,  LabelDto labelDto);
    Response removeLabel(String token, int noteId,  LabelDto labelDto);
    Response addReminder(String token, int noteId, ReminderDto reminderDto);
    Response removeReminder(String token, int noteId);
}
