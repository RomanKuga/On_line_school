package com.univer.homeWork28;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;
import com.univer.models.Lecture;
import com.univer.repository.RepositoryAddMaterial;
import com.univer.repository.RepositoryLecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Consumer;

public class HomeWork28 {
    private static final String LOG_STORAGE_FILE = "src/com/univer/Log_Info.txt";

    public void logFileMessageInfo() throws IOException {
        long indexLine = 0;
        try (var logList = Files.lines(Path.of(LOG_STORAGE_FILE))) {
            indexLine = logList.count();
        } catch (IOException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка побудови Stream потока до файла Log", LocalDateTime.now(),
                    e.getStackTrace()));
        }
        try (var logList = Files.lines(Path.of(LOG_STORAGE_FILE))) {

            Consumer<String> printInfoMessage = element -> {
                if (element.contains("INFO")) {
                    System.out.println(element);
                }
            };
            logList.skip(indexLine / 2).forEach(printInfoMessage);
        } catch (IOException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка побудови Stream потока до файла Log", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }

    public void minDateMaxAddMaterialLecture() throws IOException {
        List tempListLecture = RepositoryLecture.getInstance().getModelsList();
        List<Lecture> wers = tempListLecture;

        List<LocalDateTime> dateTimeList = wers.stream().filter(Objects::nonNull).map(Lecture::getHoldingTimeLecture).toList();
        Optional<LocalDateTime> minDateTime = dateTimeList.stream().min(LocalDateTime::compareTo);
        List<Lecture> lectureListDate = wers.stream().filter(element -> element.getHoldingTimeLecture().equals(minDateTime.get())).toList();

        TreeMap<Integer, Lecture> integerLectureMap = new TreeMap<>();
        for (Lecture element : lectureListDate) {

            if (RepositoryAddMaterial.getInstance().createMapAddMaterial().get(element.getID()) != null) {
                integerLectureMap.put(RepositoryAddMaterial.getInstance().createMapAddMaterial().get(element.getID()).size(), element);
            } else {
                integerLectureMap.put(0, element);
            }
        }
        System.out.println(integerLectureMap.get(integerLectureMap.size()));
    }
}

