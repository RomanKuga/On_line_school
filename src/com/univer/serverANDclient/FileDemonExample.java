package com.univer.serverANDclient;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileDemonExample {

    public Set<String> readBlackListFile(Path path) {
        Set<String> blackList = new HashSet<>();

        try {
            WatchService watchService = FileSystems.getDefault().newWatchService();
            path.getParent().register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

            while (true) {

                WatchKey watchKey = watchService.take();

                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    if(event.context().equals(path.getFileName())) {
                        try(Stream<String> lines = Files.lines(path)) {
                            blackList = lines.collect(Collectors.toSet());
                        }
                    }
                }

                boolean valid = watchKey.reset();

                if(!valid) {
                    break;
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return blackList;
    }
}
