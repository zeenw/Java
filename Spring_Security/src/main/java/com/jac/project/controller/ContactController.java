package com.jac.project.controller;

import com.jac.project.exception.DatabaseException;
import com.jac.project.model.Contact;
import com.jac.project.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(maxAge = 45000)
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("/new")
    public ResponseEntity<Contact> newContact(@RequestBody Contact contact) {
        try {
            return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @GetMapping("/getContactList")
    public ResponseEntity<List<Contact>> getContactList() {
        try {
            return new ResponseEntity<>(contactService.getContactList(), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @GetMapping("/getContactListBySelf/{lastName}")
    public ResponseEntity<List<Contact>> getContactListBySelf(@PathVariable String lastName) {
        try {
            return new ResponseEntity<>(contactService.getContactListBySelf(lastName), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @GetMapping("/feedback/{id}")
    public ResponseEntity<Contact> getContactListBySelf(@PathVariable Integer id, ModelAndView modelAndView) {
        try {
            return new ResponseEntity<>(contactService.getContact(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    @PostMapping("/saveContact")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        try {
            return new ResponseEntity<>(contactService.saveContact(contact), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }



    @PutMapping("/modifyContact")
    public ResponseEntity<Contact> modifyContact(@RequestBody Contact contact) {
        try {
            return new ResponseEntity<>(contactService.modifyContact(contact), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

//    @DeleteMapping("/deleteContact")
//    public ResponseEntity<Integer> deleteContact(@RequestBody Contact contact) {
//        try {
//            return new ResponseEntity<>(contactService.deleteContact(contact), HttpStatus.OK);
//        } catch (Exception e) {
//            throw new DatabaseException(e.getMessage());
//        }
//    }

    @DeleteMapping("/deleteContact/{id}")
    public ResponseEntity<Integer> deleteContact(@PathVariable Contact id, ModelAndView modelAndView) {
        try {
            return new ResponseEntity<>(contactService.deleteContact(id), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    @PutMapping("/feedbackContact")
    public ResponseEntity<Contact> feedbackContact(@RequestBody Contact contact) {
        try {
            return new ResponseEntity<>(contactService.feedbackContact(contact), HttpStatus.OK);
        } catch (Exception e) {
            throw new DatabaseException(e.getMessage());
        }
    }

}



