package com.azubike.ellpisis.repository;

import com.azubike.ellpisis.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory , Integer> {
}
