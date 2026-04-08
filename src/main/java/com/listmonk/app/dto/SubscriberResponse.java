package com.listmonk.app.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubscriberResponse {

    private Long id;
    private String email;
    private String name;
    private String status;
}
