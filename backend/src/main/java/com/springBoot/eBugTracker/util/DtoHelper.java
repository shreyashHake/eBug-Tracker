package com.springBoot.eBugTracker.util;

import com.springBoot.eBugTracker.dtos.customer.BugDTO;
import com.springBoot.eBugTracker.dtos.customer.CustomerProfileDTO;
import com.springBoot.eBugTracker.dtos.customer.CustomerProjectDTO;
import com.springBoot.eBugTracker.dtos.customer.UserDTO;
import com.springBoot.eBugTracker.entity.User;
import com.springBoot.eBugTracker.entity.customer.Bug;
import com.springBoot.eBugTracker.entity.customer.CustomerProfile;
import com.springBoot.eBugTracker.entity.customer.CustomerProject;
import org.springframework.stereotype.Service;

@Service
public class DtoHelper {

    public UserDTO getUserDto(User user){
        return new UserDTO(
                user.getUserName()
        );
    }
    public CustomerProfileDTO getCustomerProfileDto(CustomerProfile customerProfile){
        return new CustomerProfileDTO(
                customerProfile.getCustomerProfileId(),
                customerProfile.getCustomerName(),
                customerProfile.getCustomerCompany(),
                getUserDto(customerProfile.getUser())
        );
    }

    public CustomerProjectDTO getCustomerProjectDto(CustomerProject customerProject){
        return new CustomerProjectDTO(
                customerProject.getProjectId(),
                customerProject.getProjectName(),
                customerProject.getProjectDomain(),
                customerProject.getProjectDesc(),
                getCustomerProfileDto(customerProject.getCustomerProfile())
        );
    }

    public BugDTO getBugDto(Bug bug){
        return new BugDTO(
                bug.getBug_id(),
                bug.getBug_title(),
                bug.getBug_desc(),
                bug.getBug_status(),
                getCustomerProjectDto(bug.getCustomerProject())
        );
    }
}
