package com.yw.spring.finalex.repository;

import com.yw.spring.finalex.model.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationRepository extends MongoRepository<Reservation, String> {
}
