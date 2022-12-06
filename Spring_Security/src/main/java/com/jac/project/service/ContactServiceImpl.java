package com.jac.project.service;

import com.jac.project.model.Contact;
import com.jac.project.repository.ContactRepository;
import com.jac.project.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService {
    
    @Autowired
    private ContactRepository contactRepository;
    
    @Override
    public List<Contact> getContactList() {
        
        return contactRepository.findAll();
    }

    @Override
    public Contact getContact(Integer id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> getContactListBySelf(String lastName) {
        if (!"".equals(lastName) && lastName.length() > 0) {
                return contactRepository.getContactListBySelf(lastName);
        }
        return new ArrayList<Contact>();
    }

    @Override
    public Contact saveContact(Contact contact) {
        if(null != contact) {
            Contact contact_result = contactRepository.save(contact);
            return contact_result;
        }
        return null;
    }

    @Override
    public int deleteContact(Contact contact) {
        if(null != contact && null != contact.getCuid()) {
            try {
                contactRepository.delete(contact);
                return 1;
            }catch(Exception exception){
                log.error("deleteContact have a exception" + exception);
                return 0;
            }
        }
        return 0;
    }

    @Override
    public Contact modifyContact(Contact contact) {
        if(null != contact) {
            Contact contact_result = contactRepository.save(contact);
            return contact_result;
        }
        return null;
    }

    @Override
    public Contact feedbackContact(Contact contact) {
        if(null != contact) {
            if(contact.getFeedback().length() > 0){
                Contact contact_result = contactRepository.save(contact);
                return contact_result;
            }
        }
        return null;
    }
}


