package com.redabens.skillstree.controller;

import com.google.gson.Gson;
import com.redabens.skillstree.entity.Referential;
import com.redabens.skillstree.service.ReferentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/referential")
@CrossOrigin("*")
public class ReferentialController {

    @Autowired
    private ReferentialService referentialService;

    @PostMapping(value = "/referentials", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> referentials(){
        Gson gson = new Gson();
        HashMap<String, ArrayList<HashMap<String, String>>> map = new HashMap<>();
        List<Referential> referentials = referentialService.getAllReferentials();

        if (referentials != null)
        {
            ArrayList<HashMap<String, String>> refs = new ArrayList<>();
            for (Referential referential :
                    referentials) {
                HashMap<String, String> ref = new HashMap<>();
                ref.put("id", String.valueOf(referential.getId()));
                ref.put("name", referential.getName());
                refs.add(ref);
            }
            map.put("referentials",refs);
        }
        else
        {
            ArrayList<HashMap<String, String>> refs = new ArrayList<>();
            HashMap<String, String> error = new HashMap<>();
            error.put("error", "no referentials found");
            refs.add(error);
            map.put("referentials",refs);
        }
        return ResponseEntity.ok(gson.toJson(map));
    }


}

