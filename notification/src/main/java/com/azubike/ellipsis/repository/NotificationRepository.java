package com.azubike.ellipsis.repository;

import com.azubike.ellipsis.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
