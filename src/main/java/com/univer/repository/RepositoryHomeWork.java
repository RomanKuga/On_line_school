package com.univer.repository;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.HomeWork;
import com.univer.models.MasterModels;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class RepositoryHomeWork extends RepositoryMaster implements Serializable {

    @Serial
    private static final long serialVersionUID = 0x6fde28cc899f7a2aL;
    private static RepositoryHomeWork INSTANCE;

    private   RepositoryHomeWork() {
        super.interfaceRepository();
    }
    public static RepositoryHomeWork getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryHomeWork();

        }
        return INSTANCE;
    }

    public Map<Integer,List <HomeWork>> createMapHomeWork () throws IOException {
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Побудова Map ", LocalDateTime.now());
        Map<Integer, List<HomeWork>> mapHomeWork = new HashMap<>();
        for(int i=0; i<getModelsList().size(); i++) {
            List<HomeWork> tempList = new ArrayList<>();
            if (getModelsList().get(i)!= null) {
                for (int j=0; j<getModelsList().size(); j++) {
                    HomeWork tempHome = (HomeWork) getModelsList().get(j);

                    if (getModelsList().get(i).getID() == tempHome.getLectureId()) {
                        tempList.add((HomeWork) getModelsList().get(j));
                    }
                }

                mapHomeWork.put(getModelsList().get(i).getID(), tempList);
            }
        }
        LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Map - побудована ", LocalDateTime.now());
        return mapHomeWork;
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
