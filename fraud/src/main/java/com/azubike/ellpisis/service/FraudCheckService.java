package com.azubike.ellpisis.service;

import com.azubike.ellpisis.model.FraudCheckHistory;
import com.azubike.ellpisis.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FraudCheckService{
   private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    public boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .isFraudStar(false)
                .customerId(customerId).build());

        return false;
    }



}
