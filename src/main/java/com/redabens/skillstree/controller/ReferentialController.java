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

    @GetMapping(value = "/referentials", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, List>> referentials(){
        Map<String, List> res = new HashMap<>();
        Gson gson = new Gson();

        List<Referential> referentials = referentialService.getAllReferentials();

        if (referentials != null) {
            referentials = referentials.stream().map(ref -> {
                ref.getCompetences().forEach(c -> c.setReferential(null));
                return ref;
            }).toList();
            res.put("referentials",referentials);
            return ResponseEntity.ok(res);
        }
            HashMap<String, String> error = new HashMap<>();
            res.put("error", List.of("no referentials found"));

        return ResponseEntity.status(400).body(res);

    }


}

