package com.tgp.demo.repository;

import com.tgp.demo.model.Corridor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// This is the data layer which communicate with the service layer & database. Responsible for data access layer
//customer function can be declared here
@Repository
public interface CorridorRepository extends JpaRepository<Corridor, Long> {

    List<Corridor> findCorridorByTenantId (String TenantId);

    @Query ("SELECT c FROM Corridor c WHERE (c.sendCountry=:SendCountry or :SendCountry is NULL) AND " +
            "(c.sendCurrency=:SendCurrency or :SendCurrency is NULL)" +
            "AND (c.receiveCountry=:ReceiveCountry or :ReceiveCountry is NULL)" +
            "AND (c.receiveCurrency=:ReceiveCurrency or :ReceiveCurrency is NULL)" +
            "AND (c.payoutMethod=:PayoutMethod or :PayoutMethod is NULL)" +
            "AND (c.tenantId=:TenantId or :TenantId is NULL)" +
            "AND (c.isActive=:IsActive or :IsActive is NULL)")
    List<Corridor> findCorridorByMultipleParameters
            (String SendCountry,
             String SendCurrency,
             String ReceiveCountry,
             String ReceiveCurrency,
             String PayoutMethod,
             String TenantId,
             boolean IsActive);

    boolean existsBySendCountryAndSendCurrencyAndReceiveCountryAndReceiveCurrencyAndPayoutMethodAndTenantId
            (String SendCountry,
             String SendCurrency,
             String ReceiveCountry,
             String ReceiveCurrency,
             String PayoutMethod,
             String TenantId);
}
