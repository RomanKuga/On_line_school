package com.univer.controlWork;

import com.univer.models.Person;
import com.univer.models.Role;
import com.univer.repository.RepositoryPerson;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class ControlWork implements Runnable{
    Integer [] student = new Integer[10];
    private int taskNumber;
    private int rundomTime;

    public ControlWork(int taskNumber){
        this.taskNumber=taskNumber;
        rundomTime= (int) ((Math.random() * 6)+8);

    }

    public ControlWork() {

    }

    @Override
    public void run() {
            try {

               TimeUnit.SECONDS.sleep(rundomTime);
            } catch (InterruptedException e) {
                Thread.interrupted();
                System.out.println("Студент №" + (taskNumber+1) + "  не встиг завершити завдання, час виконання  "+ rundomTime);

            }
        System.out.println("Студент №" + (taskNumber+1) + " завершив завдання, час виконання  "+ rundomTime);


    }
public  void randomStudent(RepositoryPerson repositoryPerson){

            for (int i=0; i<student.length; i++) {
                int index = 1;
                while (index == 1) {
                    student[i] = (int) (Math.random() * 10 + 1);
                    int k = 0;
                    for (int j = 0; j < i; j++) {
                        if (Objects.equals(student[i], student[j])) {
                            k = 1;
                            break;
                        }
                    }
                    if (k != 1) {
                        index = 2;
                    }
                }
            }
            int k=0;
            for (int i=0; i<repositoryPerson.getModelsList().size(); i++) {
                Person person = (Person) repositoryPerson.getModelsList().get(i);
                if (Role.Student == person.getRole()) {
            System.out.println("Студент-" + person.getFirstName()+" "+person.getSecondName()+ " отримав білет -" + student[k]);
            k++;
        }
    }
}

}
