package utils;

import java.util.concurrent.TimeUnit;

public final class SleepUtils {

    private SleepUtils() {

    }

    public static void sleep(long mills) {
        try {
            TimeUnit.MILLISECONDS.sleep(mills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
