package com.azubike.ellipsis.repository;

import com.azubike.ellipsis.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer , Integer> {
}
