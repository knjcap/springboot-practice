package com.tgp.demo.dto.request;

import java.time.LocalDate;
import java.util.Date;

public record  CorridorRequest(
    Long id,
    String sendCountry,
    String sendCurrency,
    String receiveCountry,
    String receiveCurrency,
    String payoutMethod,
    String tenantId,
    boolean isActive) {
    }

