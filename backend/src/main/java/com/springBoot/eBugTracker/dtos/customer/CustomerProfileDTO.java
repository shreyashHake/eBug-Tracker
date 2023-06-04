package com.springBoot.eBugTracker.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProfileDTO {
    private int customerProfileId;
    private String customerName;
    private String customerCompany;
    private UserDTO user ;
}
