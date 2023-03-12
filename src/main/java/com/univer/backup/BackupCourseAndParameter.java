package com.univer.backup;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;
import com.univer.models.AddMaterial;
import com.univer.models.HomeWork;
import com.univer.models.Lecture;
import com.univer.models.Person;

import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

public class BackupCourseAndParameter  {
    private static final String FILE_Backup="src/com/univer/backupCourse.txt";


    public static void serializeLecture(List<Lecture> demoLecture, List<Person> personList, List<HomeWork> homeWorkList, List<AddMaterial> addMaterialList) throws IOException {
        try (FileOutputStream os = new FileOutputStream(FILE_Backup);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);) {
            File file = new File(FILE_Backup);
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
            objectOutputStream.writeObject(List.of( demoLecture,personList, homeWorkList, addMaterialList));

        } catch (IOException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка запису  до файла FILE_Backup", LocalDateTime.now(),
                    e.getStackTrace()));

        }
    }

    public static <E> List<E> deserialize() throws IOException {

        List<E> resultObject = null;

        try (FileInputStream fis = new FileInputStream(FILE_Backup);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            resultObject = (List<E>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Smth went wrong");
        } catch (ClassNotFoundException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка запису  до файла FILE_Backup", LocalDateTime.now(),
                    e.getStackTrace()));
        }

        return resultObject;
    }

}
