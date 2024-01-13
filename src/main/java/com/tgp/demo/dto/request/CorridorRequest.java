package com.tgp.demo.dto.request;


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

