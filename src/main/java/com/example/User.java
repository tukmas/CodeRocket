package com.example;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    private long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private int salary;

    public User(long id, String fullName, LocalDate dateOfBirth, String phoneNumber, int wage) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.salary = wage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && salary == user.salary && Objects.equals(fullName, user.fullName) && Objects.equals(dateOfBirth, user.dateOfBirth) && Objects.equals(phoneNumber, user.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, dateOfBirth, phoneNumber, salary);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", salary=" + salary +
                '}';
    }
}
