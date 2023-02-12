package com.univer.log;

import java.io.*;
import java.time.LocalDateTime;

public class LogWriter {

    private static final String LOG_STORAGE_FILE = "src/com/univer/log/Log_Info.txt";


    protected static void writeDataToFile(Log log) throws IOException {

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(LOG_STORAGE_FILE,true)))
        {
            File file = new File(LOG_STORAGE_FILE);
            int k=0;
            while (!file.exists()){
            file.createNewFile();
            k++;
            if (k==2){
                System.out.println("Проблема зі створенням фала");
                break;
            }
            }
                writer.write(log.toString());

    } catch (IOException e) {
            LogCreateObject.error(LogWriter.class.getName(),LogLevel.ERROR.name(),
                    "Error during io example", LocalDateTime.now(),
                    e.getStackTrace());

        }
        //buisness logic for writing data to log file
    }
}
