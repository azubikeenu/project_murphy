package com.azubike.ellpsis.repository;

import com.azubike.ellpsis.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
