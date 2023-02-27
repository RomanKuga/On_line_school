package com.univer.backup;

import com.univer.models.AddMaterial;
import com.univer.models.HomeWork;
import com.univer.models.Lecture;
import com.univer.models.Person;

import java.io.*;
import java.util.List;

public class BackupCourseAndParameter  {
    private static final String FILE_Backup="src/com/univer/backupCourse.txt";


    public static void serializeLecture(List<Lecture> demoLecture, List<Person> personList, List<HomeWork> homeWorkList, List<AddMaterial> addMaterialList) {
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
            throw new RuntimeException(e);

        }
    }

    public static <E> List<E> deserialize() {

        List<E> resultObject = null;

        try (FileInputStream fis = new FileInputStream(FILE_Backup);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            resultObject = (List<E>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Smth went wrong");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return resultObject;
    }

}
