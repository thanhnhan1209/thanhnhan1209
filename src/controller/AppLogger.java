package controller;

import java.io.IOException;
import java.util.logging.*;

public class AppLogger {
    private static final Logger logger = Logger.getLogger(AppLogger.class.getName());

    static {
        try {
            // Tạo thư mục logs nếu chưa có
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get("logs"));

            // Tạo FileHandler ghi log vào logs/app.log
            FileHandler fileHandler = new FileHandler("logs/app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setLevel(Level.INFO);
        } catch (IOException e) {
            System.err.println("Không thể tạo logger file: " + e.getMessage());
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}