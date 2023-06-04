package com.springBoot.eBugTracker.entity.customer;

import com.springBoot.eBugTracker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "customerProfileId",nullable = false,referencedColumnName = "customerProfileId")
    private CustomerProfile customerProfile;

}
