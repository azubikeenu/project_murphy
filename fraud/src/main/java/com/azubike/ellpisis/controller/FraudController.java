package com.azubike.ellpisis.controller;


import com.azubike.ellpisis.dto.FraudCheckResponse;
import com.azubike.ellpisis.service.FraudCheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
@Slf4j
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(value = "{customerId}")
    public ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Integer customerId) {
        final boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check request for customer {}" , customerId);
        return ResponseEntity.ok(FraudCheckResponse.builder().isFraudulent(isFraudulentCustomer).build());
    }
}
