package com.univer.homeWork27;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.log.LogWriter;
import com.univer.models.MasterModels;
import com.univer.models.Person;
import com.univer.repository.RepositoryPerson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.function.Consumer;

public class HomeWorK27 {
    private static final String LOG_STORAGE_FILE = "src/com/univer/Log_Info.txt";
    public void homeWork27Task2(){
        TreeSet<MasterModels> sortPersonList= new TreeSet<>(RepositoryPerson.getInstance().getModelsList());
        List sortTeacher= new ArrayList<>(sortPersonList);
        List <Person> studentAndTeacher1= sortTeacher;
        Character objC = 'N';
        studentAndTeacher1.stream().filter(teacher->teacher.getSecondName().charAt(0)<objC).forEach(System.out::println);
    }

    public void homeWork27Task3() throws IOException {

        try (var logList = Files.lines(Path.of(LOG_STORAGE_FILE))){

            Consumer<String> printChangeMessage= element ->{
                int k=0;
                String tempElement= element.trim();
                while (k<2){
                tempElement = tempElement.substring(tempElement.indexOf(" "),tempElement.trim().length()).trim();
                k++;}

                System.out.println(tempElement.replaceAll("[^а-яА-Я]", " "));
            };
            logList.forEach(printChangeMessage);

        } catch (IOException e) {
            System.out.println(LogCreateObject.error(LogWriter.class.getName(), LogLevel.ERROR.name(),
                    "Помилка побудови Stream потока до файла Log", LocalDateTime.now(),
                    e.getStackTrace()));
        }

    }
}
