package com.azubike.clients.fraud;

import com.azubike.clients.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fraud", url = "${clients.fraud.url}" , path = "/api/v1/fraud-check")
public interface FraudClient {
    @GetMapping(value = "{customerId}")
    ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Integer customerId);
}
