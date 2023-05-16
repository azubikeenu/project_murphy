package com.azubike.ellipsis.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Notification {

    @Id
    @SequenceGenerator(sequenceName = "notification_id_sequence", name = "notification_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    private Integer id;

    private String message;

    private String sender = "Richard";

    @CreationTimestamp
    private LocalDateTime sentAt;

    private String toCustomerEmail;

    private Integer toCustomerId;
}
