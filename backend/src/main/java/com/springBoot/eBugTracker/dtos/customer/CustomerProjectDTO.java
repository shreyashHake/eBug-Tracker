package com.springBoot.eBugTracker.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProjectDTO {
    private int projectId;
    private String projectName;
    private String projectDomain;
    private String projectDesc;
    private CustomerProfileDTO customerProfile;
}
