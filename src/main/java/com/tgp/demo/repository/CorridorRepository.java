package com.tgp.demo.repository;

import com.tgp.demo.model.Corridor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// This is the data layer which communicate with the service layer & database. Responsible for data access layer
//customer function can be declared here
@Repository
public interface CorridorRepository extends JpaRepository<Corridor, Long> {

    List<Corridor> findCorridorByTenantId (String TenantId);
    boolean existsBySendCountryAndSendCurrencyAndReceiveCountryAndReceiveCurrencyAndPayoutMethodAndTenantId
            (String SendCountry,
             String SendCurrency,
             String ReceiveCountry,
             String ReceiveCurrency,
             String PayoutMethod,
             String TenantId);
}
