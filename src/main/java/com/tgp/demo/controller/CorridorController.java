package com.tgp.demo.controller;

// This is the API layer which will talk to Service layer and from user's application

import com.tgp.demo.dto.request.CorridorRequest;
import com.tgp.demo.model.Corridor;
import com.tgp.demo.service.CorridorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/corridor")
public class CorridorController {
    private final CorridorService corridorService; //adding reference to corridor service

    @Autowired //
    public CorridorController(CorridorService corridorService) {
        this.corridorService = corridorService;
    }

    @GetMapping
    public List<Corridor> getCorridor(){
        return corridorService.getCorridor();

    }

    @PostMapping (path ="/AddNewCorridor")
    public void addNewCorridor(@RequestBody CorridorRequest corridorRequest) {
        corridorService.addNewCorridor(corridorRequest);

    }
    @PutMapping(path = "{id}")
    public void updateCorridorStatus(
            @PathVariable ("id") Long id,
            @RequestParam boolean status) {
        CorridorRequest corridorRequest;
        corridorService.updateCorridorStatus(id, status);
    }

}
