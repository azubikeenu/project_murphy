package com.azubike.ellpisis.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class FraudCheckHistory {
    @Id
    @SequenceGenerator(name = "fraud_id_sequence" , sequenceName = "fraud_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "fraud_id_sequence")
    private  Integer id ;
    private Integer customerId ;
    private Boolean isFraudStar;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
