package com.univer.controlWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ControlWork implements Runnable{

    Integer [] student = new Integer[10];
    List<Thread> threads = new ArrayList<>(10);
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
                System.out.println("Студент №" + (taskNumber+1) + "  не встиг завершити завдання");

            }
        System.out.println("Студент №" + (taskNumber+1) + " завершив завдання");


    }
public  void rundomStudent(){
    for (int i=0; i<student.length; i++){
        int index =1;
        while (index==1){
            student[i]=(int) (Math.random() * 10+1);
            int k=0;
            for (int j=0; j<i; j++){
                if ((student[i]==student[j])&&(i!=j)){
                    k=1;
                }
            }
            if (k!=1){index=2;}
        }
        System.out.println("Студент-"+(i+1)+ " отримав білет -"+ student[i]);
    }
}

}
