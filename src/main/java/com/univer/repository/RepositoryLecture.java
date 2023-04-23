package com.univer.repository;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.Lecture;
import com.univer.models.MasterModels;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class RepositoryLecture extends RepositoryMaster implements Serializable {

    @Serial
    private static final long serialVersionUID = 0x8c3430b0b88ab2ddL;
    private static RepositoryLecture INSTANCE;
    private RepositoryLecture() {
         super.interfaceRepository();
    }
    public static RepositoryLecture getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryLecture();

        }
        return INSTANCE;
    }

    public Map<Integer,List <Lecture>> createMapLecture () throws IOException {
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Побудова Map ", LocalDateTime.now());
        Map<Integer, List<Lecture>> mapLecture = new HashMap<>();
        for(int i=0; i<getModelsList().size(); i++) {
            List<Lecture> tempList = new ArrayList<>();
            Lecture tempElementLecture = (Lecture) getModelsList().get(i);
            if (getModelsList().get(i)!= null) {
                for (int j=0; j<getModelsList().size(); j++) {
                    Lecture tempHome = (Lecture) getModelsList().get(j);
                  if ((tempHome!=null)&&(tempElementLecture.getCourseIDLecture() == tempHome.getCourseIDLecture()))  {
                        tempList.add((Lecture) getModelsList().get(j));
                    }
                }
                mapLecture.put( ((Lecture) getModelsList().get(i)).getCourseIDLecture(), tempList);
            }
        }
        LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Map - побудована ", LocalDateTime.now());
        return mapLecture;
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

