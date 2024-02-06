import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GameInstaller {

    public static void main(String[] args) {
        String gamesFolderPath = "Macintosh HD/Программы/Games";
        createDirectoriesAndFiles(gamesFolderPath);
    }

    private static void createDirectoriesAndFiles(String gamesFolderPath) {
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
        createAndWriteLog(gamesFolderPath, "temp.txt");
    }

    private static void createDirectory(String parentPath, String directoryName) {
        File directory = new File(parentPath, directoryName);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Директория " + directory.getAbsolutePath() + " создана.");
            } else {
                System.out.println("Ошибка при создании директории " + directory.getAbsolutePath());
            }
        }
    }

    private static void createFile(String parentPath, String fileName) {
        File file = new File(parentPath, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Файл " + file.getAbsolutePath() + " создан.");
            } else {
                System.out.println("Ошибка при создании файла " + file.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createAndWriteLog(String gamesFolderPath, String logFileName) {
        File logFile = new File(gamesFolderPath + "/temp", logFileName);
        try (FileWriter writer = new FileWriter(logFile)) {
            writer.write("Установка завершена. Все необходимые директории и файлы созданы успешно.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



