package com.tgp.demo.service;

import com.tgp.demo.model.Corridor;
import com.tgp.demo.repository.CorridorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
// This is a service layer which communicate back and forth with the API layer, in this project its controller
@Service
public class CorridorService {
    private final CorridorRepository corridorRepository;

    @Autowired
    public CorridorService(CorridorRepository corridorRepository) {
        this.corridorRepository = corridorRepository;
    }

    public List<Corridor> getCorridor(){
        return corridorRepository.findAll();

    }

    public void addNewCorridor(Corridor corridor) {
        corridorRepository.save(corridor);
    }
}
