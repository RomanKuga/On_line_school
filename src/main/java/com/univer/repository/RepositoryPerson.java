package com.univer.repository;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.MasterModels;
import com.univer.models.Person;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryPerson extends RepositoryMaster implements Serializable {

    @Serial
    private static final long serialVersionUID = 0x92d8d061510570dbL;
    private static RepositoryPerson INSTANCE;
    private RepositoryPerson() {
        super.interfaceRepository();
    }
    public static RepositoryPerson getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryPerson();
        }
        return INSTANCE;
    }

    public Map<Integer,List <Person>> createMapPerson () throws IOException {
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Побудова Map ", LocalDateTime.now());
        Map<Integer, List<Person>> mapPerson = new HashMap<>();
        for(int i=0; i<getModelsList().size(); i++) {
            List<Person> tempList = new ArrayList<>();
            Person tempElementPerson = (Person) getModelsList().get(i);
            if (getModelsList().get(i)!= null) {
                for (int j=0; j<getModelsList().size(); j++) {
                    Person tempHome = (Person) getModelsList().get(j);
                    if ((tempHome!=null)&&(tempElementPerson.getCourseId() == tempHome.getCourseId()))  {
                        tempList.add((Person) getModelsList().get(j));
                    }
                }
                mapPerson.put( ((Person) getModelsList().get(i)).getCourseId(), tempList);
            }
        }
        LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Map - побудована ", LocalDateTime.now());
        return mapPerson;
    }
    @Override
    public List<MasterModels> getModelsList() {
        return super.getModelsList();
    }

    @Override
    public List<MasterModels> findAll() {
        return super.findAll();
    }


}