package com.jac.project.model;
import lombok.*;
import org.hibernate.criterion.Example;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="contactus")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cuid")
    private Integer cuid;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "message")
    private String message;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "feedback_time")
    private String feedbackTime;

    @Column(name = "feedback_user")
    private String feedbackUser;
}
