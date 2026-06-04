package com.iankyo.bank_api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponseV2 {
    private Long id;
    private String fullName;
    private String email;
    private LocalDateTime createdAt;
}
