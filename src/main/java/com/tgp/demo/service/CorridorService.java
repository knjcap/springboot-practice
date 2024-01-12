package com.tgp.demo.service;

import com.tgp.demo.dto.request.CorridorRequest;
import com.tgp.demo.exceptionHandlers.DuplicateResourceException;
import com.tgp.demo.exceptionHandlers.ResourceNotFoundException;
import com.tgp.demo.model.Corridor;
import com.tgp.demo.repository.CorridorRepository;
import org.hibernate.annotations.TenantId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
// This is a service layer which communicate back and forth with the API layer(in project its controller).
// This is where the business logic are defined.
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
    public List<Corridor> getCorridorByTenantId(String tenantID){
        return corridorRepository.findCorridorByTenantId(tenantID);
    }

    public void addNewCorridor(CorridorRequest corridorRequest) {
        boolean exist = corridorRepository.existsBySendCountryAndSendCurrencyAndReceiveCountryAndReceiveCurrencyAndPayoutMethodAndTenantId
                (corridorRequest.sendCountry(), corridorRequest.sendCurrency(), corridorRequest.receiveCountry(),
                        corridorRequest.receiveCurrency(), corridorRequest.payoutMethod(), corridorRequest.tenantId());
        if (exist) {
            throw new DuplicateResourceException(String.format("Corridor with Send Country = %s, Send Currency = %s, " +
                    "Receive Country = %s, Receive Currency = %s, Payout Method = %s, Tenant ID = %s already exists",
                    corridorRequest.sendCountry(), corridorRequest.sendCurrency(), corridorRequest.receiveCountry(),
                    corridorRequest.receiveCurrency(), corridorRequest.payoutMethod(), corridorRequest.tenantId()));
        }
        Corridor corridor = Corridor.builder()
                .sendCountry(corridorRequest.sendCountry())
                .sendCurrency(corridorRequest.sendCurrency())
                .receiveCountry(corridorRequest.receiveCountry())
                .receiveCurrency(corridorRequest.receiveCurrency())
                .payoutMethod(corridorRequest.payoutMethod())
                .tenantId(corridorRequest.tenantId())
                .isActive(corridorRequest.isActive())
                .build();
        corridorRepository.save(corridor);
    }
    @Transactional
    public void updateCorridorStatus (Long id, boolean status) {
        Corridor corridor = corridorRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException ("Corridor does not exist"));
        corridor.setActive(status);
        corridorRepository.save(corridor);

    }
}
