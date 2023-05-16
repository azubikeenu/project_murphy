package com.azubike.ellipsis.repository;

import com.azubike.ellipsis.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory , Integer> {
}
