package com.yw.spring.finalex.repository;

import com.yw.spring.finalex.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, String> {
}
