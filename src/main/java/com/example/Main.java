package com.example;

import java.io.File;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        File filePath = new File("C:\\Users\\Sergey\\Downloads\\data.txt");
        TextFileReader fileReader = new TextFileReader();
        List<User> users = fileReader.readData(filePath);

        UserAnalyzer userAnalyzer = new UserAnalyzer(users);
        userAnalyzer.printUserList(users);
        userAnalyzer.printUserCounts();
        userAnalyzer.printUserAgeGreaterThan(25);
        userAnalyzer.printAverageSalary();
        userAnalyzer.printWomenWithPhoneNumberCount();
    }
}