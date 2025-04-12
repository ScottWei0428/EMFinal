package com.yw.spring.finalex.repository;

import com.yw.spring.finalex.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String> {
}
