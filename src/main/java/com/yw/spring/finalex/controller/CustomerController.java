package com.yw.spring.finalex.controller;

import com.yw.spring.finalex.model.Customer;
import com.yw.spring.finalex.repository.CustomerRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping
    public String customerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer";
    }

    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer, Model model) {
        customerRepository.save(customer);
        model.addAttribute("customer", customer);
        return "customer_success";
    }
}
