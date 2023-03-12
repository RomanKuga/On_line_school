package com.univer.serverANDclient;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDateTime;

public class BlackListWriteRemove {

    private static final int B_SIZE = 1024;

    private static final String BlackList_STORAGE_FILE = "src/com/univer/BlackList.txt";

    public static void writeBlackList(String BlackListIP) throws IOException {

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(BlackList_STORAGE_FILE, true));
             FileChannel fileReader = new FileInputStream(BlackList_STORAGE_FILE).getChannel()) {
            File file = new File(BlackList_STORAGE_FILE);
            int k = 0;
            if(!file.exists()) {
                while (!file.createNewFile()) {
                    k++;
                    if (k == 2) {
                        System.out.println("Проблема зі створенням фала");
                        break;
                    }
                }

            }
            ByteBuffer buffer = ByteBuffer.allocate(B_SIZE);
            fileReader.read(buffer);
            buffer.flip();
            if (buffer.limit() != 0) {
                char[] chars = new char[buffer.limit()];
                int j = 0;
                while (buffer.hasRemaining()) {
                    chars[j] = (char) buffer.get();
                    j++;
                }
                String storageBlackList = String.copyValueOf(chars);
                if (storageBlackList.contains(BlackListIP)) {
                    System.out.println("Введена IP вже є у списку");
                } else {
                    writer.write(BlackListIP+"\n");
                }
            }else {
                writer.write(BlackListIP+"\n");
            }

        } catch (IOException e) {
            LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Error during io example", LocalDateTime.now(),
                    e.getStackTrace());

        }

    }


    public static void removeBlackList(String BlackListIP) throws IOException {

        try (FileChannel fileReader = new FileInputStream(BlackList_STORAGE_FILE).getChannel()) {
            File file= new File(BlackList_STORAGE_FILE);
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
            ByteBuffer buffer = ByteBuffer.allocate(B_SIZE);
            fileReader.read(buffer);
            buffer.flip();
            if (buffer.limit() != 0) {
                char[] chars = new char[buffer.limit()];
                int j = 0;
                while (buffer.hasRemaining()) {
                    chars[j] = (char) buffer.get();
                    j++;
                }
                String storageBlackList = String.copyValueOf(chars);
                if (!storageBlackList.contains(BlackListIP)) {
                    System.out.println("Введена IP в списку не має");
                } else {
                    Writer writer = new OutputStreamWriter(new FileOutputStream(BlackList_STORAGE_FILE));
                    writer.write(storageBlackList.replace(BlackListIP, ""));
                    writer.close();
                }
            }


        } catch (IOException e) {
            LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Error during io example", LocalDateTime.now(),
                    e.getStackTrace());
        }
    }

    public static String printBlackList() throws IOException {

        try (FileChannel fileReader = new FileInputStream(BlackList_STORAGE_FILE).getChannel()) {

            File file = new File(BlackList_STORAGE_FILE);
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
            ByteBuffer buffer = ByteBuffer.allocate(B_SIZE);
            fileReader.read(buffer);
            buffer.flip();
            if (buffer.limit() != 0) {
                char[] chars = new char[buffer.limit()];
                int j = 0;
                while (buffer.hasRemaining()) {
                    chars[j] = (char) buffer.get();
                    j++;
                }
                return String.copyValueOf(chars);
            }
            else {
                System.out.println("Файл пустий");
            }
        }
        return null;
    }
}