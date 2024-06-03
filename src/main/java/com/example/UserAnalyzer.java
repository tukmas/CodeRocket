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
    public void getGenderCounts(List<User> users) {
        long maleCount = users.stream()
                .filter(user -> user.getFullName().endsWith("ович") || user.getFullName().endsWith("ич"))
                .count();

        long femaleCount = users.size() - maleCount;

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

    public static void getCountOfWomenWithValidPhoneNumbers(List<User> users) {
        long count = users.stream()
                .filter(user -> (user.getFullName().endsWith("ова") || user.getFullName().endsWith("евна") || user.getFullName().endsWith("овна"))
                        && (user.getPhoneNumber().matches("9\\d{9}") || user.getPhoneNumber().matches("[78]\\d{10}")))
                .count();

        System.out.println("Количество женщин с валидным номером телефона: " + count);
    }
    public void displayUsersWithInvalidData(List<User> users) {
        for (User user : users) {
            boolean isValid = true;

            if (user.getFullName().isEmpty()) {
                System.out.println("Пользователь " + user.getFullName() + " с ID " + user.getId() + " имеет пустое поле ФИО");
                isValid = false;
            }

            if (user.getDateOfBirth() == null) {
                System.out.println("Пользователь " + user.getFullName() + " с ID " + user.getId() + " имеет неверный формат даты рождения");
                isValid = false;
            }

            if (!user.getPhoneNumber().matches("9\\d{9}") && !user.getPhoneNumber().matches("[78]\\d{10}")) {
                System.out.println("Пользователь " + user.getFullName() + " с ID " + user.getId() + " имеет некорректный номер телефона");
                isValid = false;
            }

            if (user.getSalary() <= 0) {
                System.out.println("Пользователь " + user.getFullName() + " с ID " + user.getId() + " имеет неверное значение заработной платы");
                isValid = false;
            }

            if (!isValid) {
                System.out.println("=====================");
            }
        }
    }
}