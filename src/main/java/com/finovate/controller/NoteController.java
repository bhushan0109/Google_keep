package com.finovate.controller;

import com.finovate.dto.LabelDto;
import com.finovate.dto.NoteDto;
import com.finovate.dto.ReminderDto;
import com.finovate.exception.NoteException;
import com.finovate.exception.UserException;
import com.finovate.model.Response;
import com.finovate.service.NoteServiceImplimentation;
import com.finovate.utility.ResponseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteServiceImplimentation noteService;

    @PostMapping("/creation")
    public ResponseEntity<Response> create(@RequestBody NoteDto noteDto, @RequestHeader String token) {
        Response response =null;
        if(noteDto.getTitle().equals("") && noteDto.getDescription().equals("")) {
            response = ResponseInfo.getResponse(-700, "Entering Data in title and description is mandatory");
        }else
            response = noteService.create(noteDto, token);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@Valid @RequestBody NoteDto noteDTO, @RequestHeader String token, @PathVariable int id) {
        Response response = noteService.update(noteDTO, token, id);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@RequestHeader String token, @PathVariable int id) {
        Response response = noteService.delete(token, id);
        return new ResponseEntity(response, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Object> getAllNotes(@RequestHeader String token) {
        Object obj;
        try {
            obj = noteService.getAllNotes(token);
        }
        catch(UserException e){
            obj = ResponseInfo.getResponse(e.getErrorCode(),e.getMessage());
        }
        return new ResponseEntity(obj,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNote(@RequestHeader String token, @PathVariable int id) {
        Object obj;
        try {
            obj = noteService.getNote(token, id);
            return new ResponseEntity<>(obj,HttpStatus.OK);
        }
        catch(UserException e){
            obj = ResponseInfo.getResponse(e.getErrorCode(),e.getMessage());
        }
        catch(NoteException e){
            obj = ResponseInfo.getResponse(e.getErrorCode(),e.getMessage());
        }
        return new ResponseEntity(obj,HttpStatus.OK);
    }

    @PutMapping("/pin/{id}")
    public ResponseEntity<Response> pinNote(@RequestHeader String token, @PathVariable int id){
        Response response = noteService.pinNote(token, id);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PutMapping("/trash/{id}")
    public ResponseEntity<Response> trashNote(@RequestHeader String token, @PathVariable int id){
        Response response = noteService.trashNote(token, id);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PutMapping("/archive/{id}")
    public ResponseEntity<Response> archiveNote(@RequestHeader String token, @PathVariable int id){
        Response response = noteService.archiveNote(token, id);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PostMapping("/{noteId}/labels")
    public ResponseEntity<Response> addLabel(@RequestHeader String token, @PathVariable int noteId, @RequestBody LabelDto labelDto){
        Response response;
        if(labelDto.getName().equals("") || labelDto.getName() == null)
            response = ResponseInfo.getResponse(-800, "label can't not be empty");
        else
            response = noteService.addLabel(token, noteId, labelDto);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PutMapping("/{noteId}/labels")
    public ResponseEntity<Response> removeLabel(@RequestHeader String token, @PathVariable int noteId, @RequestBody LabelDto labelDto){
        Response response;
        if(labelDto.getName().equals("") || labelDto.getName() == null)
            response = ResponseInfo.getResponse(-800, "Entering Label Name is Mandatory");
        else
            response = noteService.removeLabel(token, noteId, labelDto);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PostMapping("/{noteId}/reminder")
    public ResponseEntity<Response> addReminder(@RequestHeader String token, @PathVariable int noteId, @RequestBody ReminderDto reminderDto){
        Response response = noteService.addReminder(token, noteId, reminderDto);
        return new ResponseEntity(response,HttpStatus.OK);
    }

    @PutMapping("/{noteId}/reminder")
    public ResponseEntity<Response> removeReminder(@RequestHeader String token, @PathVariable int noteId){
        Response response = noteService.removeReminder(token, noteId);
        return new ResponseEntity(response,HttpStatus.OK);
    }
}
