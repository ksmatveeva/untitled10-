package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {

    public static void main(String[] args) {

        String gamesFolderPath =  "Macintosh HD/Программы/Games";


        createDirectories(gamesFolderPath);

        writeLogToFile(gamesFolderPath, "temp.txt");
    }

    private static void createDirectories(String gamesFolderPath) {
        createDirectory(gamesFolderPath, "src");
        createDirectory(gamesFolderPath + "/src", "main");
        createDirectory(gamesFolderPath + "/src", "test");
        createDirectory(gamesFolderPath, "res");
        createDirectory(gamesFolderPath + "/res", "drawables");
        createDirectory(gamesFolderPath + "/res", "vectors");
        createDirectory(gamesFolderPath + "/res", "icons");
        createDirectory(gamesFolderPath, "savegames");
        createDirectory(gamesFolderPath, "temp");
        createFile(gamesFolderPath + "/temp", "temp.txt");
    }

    private static void createDirectory(String parentPath, String directoryName) {
        File directory = new File(parentPath, directoryName);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                appendToLog("Директория " + directory.getAbsolutePath() + " создана.");
            } else {
                appendToLog("Ошибка при создании директории " + directory.getAbsolutePath());
            }
        }
    }

    private static void createFile(String parentPath, String fileName) {
        File file = new File(parentPath, fileName);
        try {
            if (file.createNewFile()) {
                appendToLog("Файл " + file.getAbsolutePath() + " создан.");
            } else {
                appendToLog("Ошибка при создании файла " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void appendToLog(String message) {
        //System.out.println(message);  // Выводим сообщение в консоль
        log.append(message).append("\n");
    }

    private static void writeLogToFile(String gamesFolderPath, String logFileName) {
        File logFile = new File(gamesFolderPath + "/temp", logFileName);
        try (FileWriter writer = new FileWriter(logFile)) {
            writer.write(log.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder log = new StringBuilder();
}




