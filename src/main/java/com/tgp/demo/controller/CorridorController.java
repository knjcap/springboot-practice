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

    @GetMapping (path="/all")
    public List<Corridor> getCorridor(){
        return corridorService.getCorridor();

    }
    @GetMapping (path="/search by")
    public List<Corridor> getCorridorByTenantId(
            @RequestParam String tenantId) {
        return corridorService.getCorridorByTenantId(tenantId);
    }
    @GetMapping (path="/search by fields/")
    public List<Corridor> findCorridorByMultipleParameters(
            @RequestParam (required = false) String SendCountry,
            @RequestParam (required = false) String SendCurrency,
            @RequestParam (required = false) String ReceiveCountry,
            @RequestParam (required = false) String ReceiveCurrency,
            @RequestParam (required = false) String PayoutMethod,
            @RequestParam (required = false) String TenantId,
            @RequestParam (required = false, defaultValue = "true") boolean IsActive) {
        return corridorService.findCorridorByMultipleParameters
                (SendCountry,
                SendCurrency,
                ReceiveCountry,
                ReceiveCurrency,
                PayoutMethod,
                TenantId,
                IsActive);

    }

    @PostMapping (path ="/AddNewCorridor")
    public void addNewCorridor(@RequestBody CorridorRequest corridorRequest) {
        corridorService.addNewCorridor(corridorRequest);

    }

    @PutMapping(path = "/updateCorridorStatus/{id}")
    public void updateCorridorStatus(
            @PathVariable ("id") Long id,
            @RequestParam boolean status) {
        CorridorRequest corridorRequest;
        corridorService.updateCorridorStatus(id, status);
    }

}
