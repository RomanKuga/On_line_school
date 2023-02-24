package com.univer.serverANDclient;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class RunDemon implements Runnable {
    Set<String> lastModified = new HashSet<>();
    private static final String BlackList_STORAGE_FILE = "src/com/univer/BlackList.txt";

    public RunDemon() {
        Thread thread = new Thread();
        thread.setDaemon(true);
    }

    @Override
    public void run() {

            Set<String> blackListDemo = new FileDemonExample().readBlackListFile(Path.of(BlackList_STORAGE_FILE));


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if(lastModified != blackListDemo) {
                System.out.println("Black list has been updeted");
                lastModified.clear();

                lastModified = blackListDemo;
            }
        }
    }

