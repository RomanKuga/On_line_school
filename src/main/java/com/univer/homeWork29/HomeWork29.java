package com.univer.homeWork29;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;
import com.univer.models.AddMaterial;
import com.univer.models.Lecture;
import com.univer.models.Person;
import com.univer.models.Role;
import com.univer.repository.RepositoryAddMaterial;
import com.univer.repository.RepositoryLecture;
import com.univer.repository.RepositoryPerson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeWork29 {
    private static final String EMAIL_STORAGE_FILE = "src/main/java/com/univer/email_Student.txt";

    public void lectureGroupOfTeacher() {
        List tempListLecture = RepositoryLecture.getInstance().getModelsList();
        List<Lecture> wers = tempListLecture;
        Map<Integer, List<Lecture>> lectureGroupOfTeacherNumber = wers.stream().collect(
                Collectors.groupingBy(Lecture::getLecturePersonId));
        System.out.println(lectureGroupOfTeacherNumber);
    }

    public void lectureGroupOfAddMaterial() {
        List tempAddMaterial = RepositoryAddMaterial.getInstance().getModelsList();
        List<AddMaterial> addMaterialList = tempAddMaterial;
        Map<Integer, List<AddMaterial>> lectureGroupOfAddMaterial = addMaterialList.stream().collect(
                Collectors.groupingBy(AddMaterial::getLectureId));
        System.out.println(lectureGroupOfAddMaterial);
    }

    public void mailNameSecondNameMap() {
        List tempPerson = RepositoryPerson.getInstance().getModelsList();
        List<Person> personList = tempPerson;
        Map<String, String> mailNameSecondNameMap = personList.stream().collect(
                Collectors.toMap(i -> i.getEmail(), a -> a.getSecondName() + " " + a.getFirstName()));
        System.out.println(mailNameSecondNameMap);
    }

    public void mailStudentToFile() throws IOException {
        List tempPerson = RepositoryPerson.getInstance().getModelsList();
        List<Person> personList = tempPerson;
        List<String> emailStudent = personList.stream().map(i -> {
            i.getRole().equals(Role.Student);
            return i.getEmail();
        }).sorted().toList();
        try (var logList = Files.newBufferedWriter(Path.of(EMAIL_STORAGE_FILE))) {
            File file = new File(EMAIL_STORAGE_FILE);
            int k = 0;
            if (!file.exists()) {
                while (!file.createNewFile()) {
                    k++;
                    if (k == 2) {
                        System.out.println("Проблема зі створенням фала");
                        break;
                    }
                }
            }
            for (String element : emailStudent) {
                logList.write(element + "\n");
            }
        } catch (IOException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка запису Stream потока до файла Log", LocalDateTime.now(),
                    e.getStackTrace()));
        }
    }
}
