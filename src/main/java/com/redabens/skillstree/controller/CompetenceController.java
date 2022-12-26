package com.redabens.skillstree.controller;

import com.google.gson.Gson;
import com.redabens.skillstree.entity.Competence;
import com.redabens.skillstree.entity.Referential;
import com.redabens.skillstree.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/competence")
@CrossOrigin("*")
public class CompetenceController {

    @Autowired
    private CompetenceService competenceService;

    @PostMapping(value = "/competences", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> competences(){
        Gson gson = new Gson();
        HashMap<String, ArrayList<HashMap<String, String>>> map = new HashMap<>();
        List<Competence> competences = competenceService.getAllCompetences();

        if (competences != null)
        {
            ArrayList<HashMap<String, String>> comps = new ArrayList<>();
            for (Competence competence:
                    competences) {
                HashMap<String, String> comp = new HashMap<>();
                comp.put("id", String.valueOf(competence.getId()));
                comp.put("name", competence.getName());
                comp.put("description", competence.getDescription());
                comp.put("referential", String.valueOf(competence.getIdReferential()));
                comps.add(comp);
            }
            map.put("competences",comps);
        }
        else
        {
            ArrayList<HashMap<String, String>> comps = new ArrayList<>();
            HashMap<String, String> error = new HashMap<>();
            error.put("error", "no competences found");
            comps.add(error);
            map.put("competences",comps);
        }
        return ResponseEntity.ok(gson.toJson(map));
    }


}

