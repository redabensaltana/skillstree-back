package com.redabens.skillstree.service;

import com.redabens.skillstree.dao.BaseDAOImpl;
import com.redabens.skillstree.entity.Competence;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenceService {
    private BaseDAOImpl<Competence> competenceBaseDAO = new BaseDAOImpl<>(Competence.class);

    public List<Competence> getAllCompetences(){
        List<Competence> competences = competenceBaseDAO.getAll();
        if (competences.size() > 0)
        {
            return competences;
        }
        return null;
    }

}
