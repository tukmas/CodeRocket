package com.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class UserAnalyzer {
    private List<User> users;

    public UserAnalyzer(List<User> users) {
        this.users = users;
    }
    public void printUserList(List<User> userList) {
        userList.stream().forEach(System.out::println);
    }
    public void printUserCounts() {
        long maleCount = users.stream()
                .filter(user -> user.getGender().equals("муж"))
                .count();
        long femaleCount = users.stream()
                .filter(user -> user.getGender().equals("жен"))
                .count();

        System.out.println("Количество мужчин: " + maleCount);
        System.out.println("Количество женщин: " + femaleCount);
    }

    public void printUserAgeGreaterThan(int age) {
        long count = users.stream()
                .filter(user -> Period.between(user.getDateOfBirth(), LocalDate.now()).getYears() >= age)
                .count();

        System.out.println("Количество пользователей с возрастом больше " + age + " лет: " + count);
    }

    public void printAverageSalary() {
        double averageSalary = users.stream()
                .mapToDouble(User::getSalary)
                .average()
                .orElse(0);

        System.out.println("Средняя заработанная плата: " + averageSalary);
    }

    public void printWomenWithPhoneNumberCount() {
        long countWomenWithPhoneNumber = users.stream()
                .filter(user -> user.getGender().equals("жен"))
                .filter(user -> user.getPhoneNumber() != null && !user.getPhoneNumber().isEmpty())
                .count();

        System.out.println("Количество женщин с номером телефона: " + countWomenWithPhoneNumber);
    }
}