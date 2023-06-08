package com.springBoot.eBugTracker.entity.bugs;

import com.springBoot.eBugTracker.entity.staff.StaffProfile;
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
public class BugProcess {
    @Id
    @GeneratedValue
    private int bugProcessId;
    private String GlobalStatus;
    @OneToOne
    @JoinColumn(name = "staffProfileId",referencedColumnName = "staffProfileId")
    private StaffProfile staffProfile;
    @OneToOne
    @JoinColumn(name="BugId",nullable = false,referencedColumnName = "BugId")
    private Bug bug;
    @OneToMany(mappedBy = "bugProcess")
    private List<Comment> comments;

}
