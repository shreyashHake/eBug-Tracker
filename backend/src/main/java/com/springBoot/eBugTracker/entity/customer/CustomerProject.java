package com.springBoot.eBugTracker.entity.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springBoot.eBugTracker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CustomerProject {
    @Id
    @GeneratedValue
    private int projectId;
    private String projectName;
    private String projectDomain;
    private String projectDesc;
    private String projectStatus;
    @JsonIgnore
    private LocalDate createdDate;
    @JsonIgnore
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "customerProfileId",nullable = false,referencedColumnName = "customerProfileId")
    private CustomerProfile customerProfile;

}
