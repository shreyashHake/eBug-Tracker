package com.springBoot.eBugTracker.service.customer;

import com.springBoot.eBugTracker.dtos.customer.BugDTO;
import com.springBoot.eBugTracker.dtos.customer.CustomerProfileDTO;
import com.springBoot.eBugTracker.dtos.customer.CustomerProjectDTO;
import com.springBoot.eBugTracker.entity.User;
import com.springBoot.eBugTracker.entity.customer.Bug;
import com.springBoot.eBugTracker.entity.customer.CustomerProfile;
import com.springBoot.eBugTracker.entity.customer.CustomerProject;
import com.springBoot.eBugTracker.repository.IUserRepository;
import com.springBoot.eBugTracker.repository.customer.BugRepo;
import com.springBoot.eBugTracker.repository.customer.CustomerProfileRepo;
import com.springBoot.eBugTracker.repository.customer.CustomerProjectRepo;
import com.springBoot.eBugTracker.util.DtoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private IUserRepository iUserRepository;
    @Autowired
    private CustomerProfileRepo customerProfileRepo;
    @Autowired
    private CustomerProjectRepo customerProjectRepo;
    @Autowired
    private BugRepo bugRepo;
    @Autowired
    private DtoHelper dtoHelper;
    @Override
    public CustomerProfileDTO createCustomerProfile(CustomerProfile customerProfile) {
//        System.out.println("CP 1 :"+customerProfile);
         CustomerProfile customerProfile1 = customerProfileRepo.save(customerProfile);
//        System.out.println("CP 2 :"+customerProfile1);
//        System.out.println("CPD : "+dtoHelper.getCustomerProfileDto(customerProfile1));
        return dtoHelper.getCustomerProfileDto(customerProfile1);
    }

    @Override
    public CustomerProjectDTO createCustomerProject(CustomerProject customerProject) {
//        System.out.println("Customer Project : " +customerProject);
        CustomerProfile customerProfile = customerProfileRepo.findById(customerProject.getCustomerProfile().getCustomerProfileId()).get();
        customerProject.setCustomerProfile(customerProfile);
//        System.out.println("Customer Project 1 : " +customerProject);
        return dtoHelper.getCustomerProjectDto(customerProjectRepo.save(customerProject));
    }

    @Override
    public BugDTO addBug(Bug bug) {
//        System.out.println("Bug 1 : "+ bug);
//        System.out.println("pro id : "+bug.getCustomerProject().getProjectId());
        CustomerProject customerProject = customerProjectRepo.findById(bug.getCustomerProject().getProjectId()).get();
//        System.out.println("Customer Project 1 : " +customerProject);
        bug.setCustomerProject(customerProject);
//        System.out.println("Bug 2 : "+ bug);
        return dtoHelper.getBugDto(bugRepo.save(bug));
    }

    @Override
    public CustomerProfileDTO getCustomerProfile(String userName) {
        User user = iUserRepository.findById(userName).get();
//        System.out.println("USer : "+user);
        return dtoHelper.getCustomerProfileDto(customerProfileRepo.findByUser(user));
    }

    @Override
    public List<CustomerProjectDTO> getCustomerProjects(int profileId) {
        CustomerProfile customerProfile = customerProfileRepo.findById(profileId).get();
//        System.out.println("CustomerProfile : "+customerProfile);
        List<CustomerProjectDTO> customerProjectDTOS = new ArrayList<>();
        for (CustomerProject customerProject:
                customerProjectRepo.findByCustomerProfile(customerProfile)) {
            customerProjectDTOS.add( dtoHelper.getCustomerProjectDto(customerProject));
        }
        return customerProjectDTOS;
    }

    @Override
    public List<BugDTO> getBugs(int projectId) {
        CustomerProject customerProject = customerProjectRepo.findById(projectId).get();
        List<BugDTO> bugDTOS = new ArrayList<>();
        for (Bug bug:
                bugRepo.findByCustomerProject(customerProject)) {
            bugDTOS.add(dtoHelper.getBugDto(bug));
        }
        return bugDTOS;
    }


}
