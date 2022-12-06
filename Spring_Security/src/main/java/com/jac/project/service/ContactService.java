package com.jac.project.service;

import com.jac.project.model.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {

    /**
     * 获取所有留言
     * @return
     */
    public List<Contact> getContactList();

    /**
     * 根据Id获取Contact
     * @param id
     * @return
     */
    public Contact getContact(Integer id);

    /**
     * 获取自己的留言
     * @param contact
     * @return
     */
    public List<Contact> getContactListBySelf(String lastName);

    /**
     * Adding feedback
     * @return
     */
    public Contact saveContact(Contact contact);

    /**
     * Modifying feedback
     * @param contact
     * @return
     */
    public Contact modifyContact(Contact contact);

    /**
     * Deleting feedback
     * @param contact
     * @return
     */
    public int deleteContact(Contact contact);

    /**
     * Replying feedback
     * @param contact
     * @return
     */
    public Contact feedbackContact(Contact contact);
}
