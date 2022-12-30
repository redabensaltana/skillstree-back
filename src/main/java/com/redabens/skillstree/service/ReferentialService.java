package com.redabens.skillstree.service;

import com.redabens.skillstree.dao.BaseDAOImpl;
import com.redabens.skillstree.entity.Referential;
import com.redabens.skillstree.entity.StudentCompetenceLevel;
import com.redabens.skillstree.entity.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferentialService {
    private BaseDAOImpl<Referential> referentialBaseDAO = new BaseDAOImpl<>(Referential.class);

    public List<Referential> getAllReferentials(){
        List<Referential> referentials = referentialBaseDAO.getAll();
        if (referentials.size() > 0)
        {
            return referentials;
        }
        return null;
    }

//    public Referential getReferentialById(Long id)
//    {
//        List<Referential> referentials = referentialBaseDAO.getAllWhere("id",id);
//        if (referentials.size() > 0)
//        {
////            System.out.println(referentials.get(0));
//            return referentials.get(0);
//        }
//        return null;
//    }

}
