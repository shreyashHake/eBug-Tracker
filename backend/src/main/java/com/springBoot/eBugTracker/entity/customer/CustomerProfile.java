package com.springBoot.eBugTracker.entity.customer;

import com.springBoot.eBugTracker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CustomerProfile {
    @Id
    @GeneratedValue
    private int customerProfileId;
    private String customerName;
    private String customerCompany;
    @OneToOne
    @JoinColumn(name = "userName",nullable = false,referencedColumnName = "userName")
    private User user;

}
