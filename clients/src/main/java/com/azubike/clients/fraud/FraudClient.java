package com.azubike.ellipsis.fraud;

import com.azubike.ellipsis.fraud.dto.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "fraud", path = "api/v1/fraud-check")
public interface FraudClient {
    ResponseEntity<FraudCheckResponse> isFraudster(@PathVariable("customerId") Integer customerId);
}
