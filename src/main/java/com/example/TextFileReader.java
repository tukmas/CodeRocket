package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class TextFileReader {
    public List<User> readData(File file) {
        List<User> users = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] userData = line.split(";");

                User user = createUserFromData(userData);
                users.add(user);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return users;
    }

    private User createUserFromData(String[] userData) {
        long id = generateId();
        String fullName = getFieldValue(userData, 0);
        String gender = getFieldValue(userData, 1);
        LocalDate dateOfBirth = getLocalDateFieldValue(userData, 2, "dd.MM.yyyy");
        String phoneNumber = getFieldValue(userData, 3);
        int wage = getIntFieldValue(userData, 4, 0);

        return new User(id, fullName, gender, dateOfBirth, phoneNumber, wage);
    }

    public static long generateId() {
        return UUID.randomUUID().getLeastSignificantBits();
    }

    public static String getFieldValue(String[] data, int index) {
        if (index >= 0 && index < data.length) {
            return data[index];
        }
        return "";
    }

    public static LocalDate getLocalDateFieldValue(String[] data, int index, String pattern) {
        if (index >= 0 && index < data.length) {
            return LocalDate.parse(data[index], DateTimeFormatter.ofPattern(pattern));
        }
        return null;
    }

    public static int getIntFieldValue(String[] data, int index, int defaultValue) {
        if (index >= 0 && index < data.length) {
            try {
                return Integer.parseInt(data[index]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return defaultValue;
    }
}

