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
    private int bug_id;
    private String bug_title;
    private String bug_desc;
    private String bug_status;
    @JsonIgnore
    private LocalDate created_date;
    @ManyToOne
    @JoinColumn(name = "projectId",nullable = false,referencedColumnName = "projectId")
    private CustomerProject customerProject;
}
