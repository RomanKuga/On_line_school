package com.univer.log;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;

public class LogWriter {
    private static final int B_SIZE = 1024;

    private static final String LOG_STORAGE_FILE = "src/main/java/com/univer/Log_Info.txt";
    private static final String LOG_ADJUSTMENT_FILE = "src/main/java/com/univer/AdjustmentLog.txt";


    protected static void writeDataToFile(Log log, String logLevel) throws IOException {

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(LOG_STORAGE_FILE, true));
             FileChannel fileReader = new FileInputStream(LOG_ADJUSTMENT_FILE).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(B_SIZE);
            fileReader.read(buffer);
            buffer.flip();
            char[] chars = new char[buffer.limit()];
            int j = 0;
            while (buffer.hasRemaining()) {
                chars[j] = (char) buffer.get();
                j++;
            }
            String logAdjustment = String.copyValueOf(chars);
            File file = new File(LOG_STORAGE_FILE);
            int k = 0;
            if (!file.exists()) {

                while (file.createNewFile()) {
                    k++;
                    if (k == 2) {
                        System.out.println("Проблема зі створенням фала");
                        break;
                    }
                }
            }
            System.out.println(logAdjustment);
            if (!logAdjustment.equals("OFF")) {
                if (logAdjustment.equals(LogLevel.DEBUG.name())) {
                    writer.write(log.toString());
                }
                if (logAdjustment.equals(LogLevel.INFO.name())) {
                    if (!logLevel.equals(LogLevel.DEBUG.name())) {
                        writer.write(log.toString());
                    }
                }
                if (logAdjustment.equals(LogLevel.WARNING.name())) {
                    if ((!logLevel.equals(LogLevel.DEBUG.name())) && (!logLevel.equals(LogLevel.INFO.name()))) {
                        writer.write(log.toString());
                    }
                }
                if (logAdjustment.equals(LogLevel.ERROR.name())) {
                    if (logLevel.equals(LogLevel.ERROR.name())) {
                        writer.write(log.toString());
                    }
                }
            }

        } catch (IOException e) {
            LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Error during io example", LocalDateTime.now(),
                    e.getStackTrace());

        }

    }

    public static void writeAdjustmentFile(String logLevel) throws IOException {

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(LOG_ADJUSTMENT_FILE))) {
            File fileLogAdjustment = new File(LOG_ADJUSTMENT_FILE);
            int k = 0;
            if (!fileLogAdjustment.exists()) {

                while (fileLogAdjustment.createNewFile()) {
                    k++;
                    if (k == 2) {
                        System.out.println("Проблема зі створенням фала");
                        break;
                    }
                }
            }
            writer.write(logLevel);

        } catch (IOException e) {
            LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Error during io example", LocalDateTime.now(),
                    e.getStackTrace());

        }

    }
}
