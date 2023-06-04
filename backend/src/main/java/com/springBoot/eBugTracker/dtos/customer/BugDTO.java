package com.springBoot.eBugTracker.dtos.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BugDTO {
    private int bug_id;
    private String bug_title;
    private String bug_desc;
    private String bug_status;
    private CustomerProjectDTO customerProject;
}
