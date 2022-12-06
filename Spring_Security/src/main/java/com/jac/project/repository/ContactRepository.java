package com.jac.project.repository;


import com.jac.project.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ContactRepository extends JpaRepository<Contact,Integer> {

    @Query("select c from Contact c where c.lastName = ?1")
    public List<Contact> getContactListBySelf(String lastName);
 }
