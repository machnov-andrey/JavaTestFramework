package machnov.seleniumFramework.utilities;

import machnov.seleniumFramework.enums.TypeLogs;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {

    private static FileWriter file;

    private static void openFile() {
        try {
            var dateTime = LocalDateTime.now();
            file = new FileWriter(String.format("%s-%s-%s-%s-%s.txt", dateTime.getDayOfMonth(), dateTime.getMonth(),
                    dateTime.getYear(), dateTime.getHour(), dateTime.getMinute()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void printDebug(String message) {
        print(TypeLogs.DEBUG, message);
    }

    public static void printInfo(String message) {
        print(TypeLogs.INFO, message);
    }

    public static void printWarn(String message) {
        print(TypeLogs.WARN, message);
    }

    public static void printError(String message) {
        print(TypeLogs.ERROR, message);
    }

    public static void printFatal(String message) {
        print(TypeLogs.FATAL, message);
    }

    private static void print(TypeLogs logType, String message) {
        if (file == null) {
            openFile();
        }

        try {
            file.write(String.format("%s - %s - %s\n", LocalDateTime.now(), logType.getLogType(), message));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeFile() {
        try {
            file.close();
            file = null;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

