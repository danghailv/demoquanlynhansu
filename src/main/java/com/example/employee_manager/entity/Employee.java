package com.example.employee_manager.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;


@Entity(name = "Employee")
@Table(name = "emloyee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            updatable = false
    )
    private Long id ;
    @Column(name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstName;
    @Column(name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastName;
    @Column(name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;
    @Column(name = "date_of_birth",
            nullable = false)
    private Date dateOfBirth;
    @Column(name = "startwork")
    private Date startWork;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deparment_id")
    private Department deparment;

    public Employee(String firstName, String lastName, String email, Date dateOfBirth, Date startWork, Department deparment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.startWork = startWork;
        this.deparment = deparment;
    }

    public Employee() {

    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    public Department getDeparment() {
        return deparment;
    }

    public void setDeparment(Department deparment) {
        this.deparment = deparment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", startWork=" + startWork +
                ", deparment=" + deparment +
                '}';
    }
}