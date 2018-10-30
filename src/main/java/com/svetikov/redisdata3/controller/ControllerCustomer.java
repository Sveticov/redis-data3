package com.svetikov.redisdata3.controller;


import com.svetikov.redisdata3.model.Customer;
import com.svetikov.redisdata3.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCustomer {

    @Autowired
    private CustomerRepository customerRepository;


    @GetMapping("/save")
    public String save() {
        customerRepository.save(new Customer(1, "Jack", "Smith"));
        customerRepository.save(new Customer(2, "Adam", "Johnson"));
        customerRepository.save(new Customer(3, "Kim", "Smith"));
        customerRepository.save(new Customer(4, "David", "Williams"));
        customerRepository.save(new Customer(5, "Peter", "Davis"));

        return "Done";
    }

    @GetMapping("/findAll")
    public String findAll() {
        String res = "";

        res = customerRepository.findAll().values()
                .stream()
                .map(customer -> customer.toString() + "<br>")
                .reduce(String::concat)
                .get();

        return res;
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable(value = "id") Long id) {
        return customerRepository.find(id).toString();
    }
}
