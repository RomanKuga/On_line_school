package com.univer.repository;

import com.univer.log.LogCreateObject;
import com.univer.log.LogLevel;
import com.univer.models.AddMaterial;
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
public class RepositoryAddMaterial extends RepositoryMaster implements Serializable {

    @Serial
    private static final long serialVersionUID = 0xbffb77ba993dbe37L;
    private static RepositoryAddMaterial INSTANCE;

    private   RepositoryAddMaterial() {
        super.interfaceRepository();
    }

    public Map<Integer,List <AddMaterial>> createMapAddMaterial () throws IOException {
        LogCreateObject.logInfo(this.getClass().getName(), LogLevel.INFO.name(), "Побудова Map ", LocalDateTime.now());
        Map<Integer, List<AddMaterial>> mapAddMaterial = new HashMap<>();
        for(int i=0; i<getModelsList().size(); i++) {
            List<AddMaterial> tempList = new ArrayList<>();
            if (getModelsList().get(i)!= null) {
                for (int j=0; j<getModelsList().size(); j++) {
                    AddMaterial tempHome = (AddMaterial) getModelsList().get(j);

                    if (getModelsList().get(i).getID() == tempHome.getLectureId()) {
                        tempList.add((AddMaterial) getModelsList().get(j));
                    }
                }
                mapAddMaterial.put(getModelsList().get(i).getID(), tempList);
            }
        }
        LogCreateObject.logDebug(this.getClass().getName(), LogLevel.DEBUG.name(), "Map - побудована ", LocalDateTime.now());
        return mapAddMaterial;
    }
    @Override
    public List<MasterModels> getModelsList() {
        return super.getModelsList();
    }

    @Override
    public List<MasterModels> findAll() {
        return super.findAll();
    }
    public static RepositoryAddMaterial getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new RepositoryAddMaterial();

        }
        return INSTANCE;
    }
}
