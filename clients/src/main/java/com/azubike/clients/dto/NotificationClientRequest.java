package com.azubike.clients.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class NotificationClientRequest {

    private String message;

    private String sender;

    private String toCustomerEmail;

    private Integer toCustomerId;
}
