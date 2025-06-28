package util;

import java.io.IOException;
import java.util.logging.*;

public class AppLogger {
    private static final Logger logger = Logger.getLogger("AppLogger");
    private static FileHandler fileHandler;

    static {
        try {
            // Tạo thư mục logs nếu chưa có
            new java.io.File("logs").mkdirs();

            // File log sẽ được ghi vào thư mục logs
            fileHandler = new FileHandler("logs/app.log", true); // true = ghi tiếp
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);

            // Ghi mọi cấp độ log từ INFO trở lên
            logger.setLevel(Level.INFO);

        } catch (IOException e) {
            Logger.getAnonymousLogger().log(Level.SEVERE, "Không thể tạo log file", e);
        }
    }

    public static Logger getLogger() {
        return logger;
    }
}