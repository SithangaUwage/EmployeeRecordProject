package com.sparta.ssu.model;

import java.time.LocalDate;
import  java.time.format.DateTimeFormatter;
import java.sql.Date;

public class Employee {
    @Override
    public String toString() {
        return id + " " + namePrefix + " " + firstName + " " + middleInitial + " " + lastName + " " + gender + " " + email + " " + dateofBirth + " " + dateofJoining + " " + salary;
    }

    private String id;
    private String namePrefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String email;
    private LocalDate dateofBirth;
    private LocalDate dateofJoining;
    private int salary;

    public Employee(String[] employeeReaderArray) {
        this.id = employeeReaderArray[0];
        this.namePrefix = employeeReaderArray[1];
        this.firstName = employeeReaderArray[2];
        this.middleInitial = employeeReaderArray[3];
        this.lastName = employeeReaderArray[4];
        this.gender = employeeReaderArray[5];
        this.email = employeeReaderArray[6];
        this.dateofBirth = formatDate(employeeReaderArray[7]);
        this.dateofJoining = formatDate(employeeReaderArray[8]);
        this.salary = Integer.parseInt(employeeReaderArray[9]);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamePrefix() {
        return namePrefix;
    }

    public void setNamePrefix(String namePrefix) {
        this.namePrefix = namePrefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateofBirth() {
        return java.sql.Date.valueOf(dateofBirth);
    }

    public void setDateofBirth(LocalDate dateofBirth) {
        this.dateofBirth = dateofBirth;
    }

    public Date getDateofJoining() {
        return java.sql.Date.valueOf(dateofJoining);
    }

    public void setDateofJoining(LocalDate dateofJoining) {
        this.dateofJoining = dateofJoining;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    private LocalDate formatDate(String data) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
    return LocalDate.parse(data, formatter);
    }
}
