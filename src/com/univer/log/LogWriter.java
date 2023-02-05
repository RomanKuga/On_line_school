package com.univer.log;

import java.io.*;
import java.time.LocalDateTime;

public class LogWriter {

    private static final String LOG_STORAGE_FILE = "src/com/univer/log/Log_Info.txt";


    protected static void writeDataToFile(Log log) throws IOException {

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(LOG_STORAGE_FILE,true)))
        {
            File file = new File(LOG_STORAGE_FILE);
            if (!file.exists()){ file.createNewFile();}

                String c;
                c= log.toString();
                writer.write(c);





    } catch (IOException e) {
            LogCreateObject.error(LogWriter.class.getName(),LogLevel.ERROR.name(),
                    "Error during io example", LocalDateTime.now(),
                    e.getStackTrace());

        }
        //buisness logic for writing data to log file
    }
}
