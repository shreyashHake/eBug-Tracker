package com.springBoot.eBugTracker.entity.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bug {
    @Id
    @GeneratedValue
    private int bugId;
    private String bugTitle;
    private String bugDesc;
    private String bugStatus;
    private String bugPriority;
    @JsonIgnore
    private LocalDate createdDate;
    @JsonIgnore
    private LocalDate endDate;
    @ManyToOne
    @JoinColumn(name = "projectId",nullable = false,referencedColumnName = "projectId")
    private CustomerProject customerProject;
}
