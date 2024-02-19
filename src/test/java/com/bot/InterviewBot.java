package com.bot;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InterviewBot {
    private static final String FOLDER_PATH = "C:\\Users\\91893\\Desktop\\JavaScript\\Interview Questions & Answers";
    public static void openFileByTopic(String topic) {
        File folder = new File(FOLDER_PATH);
        File[] files = folder.listFiles();
        if (files != null) {
            List<File> matchedFiles = new ArrayList<>();
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().contains(topic.toLowerCase())) {
                    matchedFiles.add(file);
                }
            }
            if (!matchedFiles.isEmpty()) {
                try {
                    for (File file : matchedFiles) {
                        Desktop.getDesktop().open(file);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("No file containing topic '" + topic + "' found.");
            }
        } else {
            System.out.println("Folder not found or is empty.");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String topic = s.next();
        openFileByTopic(topic);
    }
}
