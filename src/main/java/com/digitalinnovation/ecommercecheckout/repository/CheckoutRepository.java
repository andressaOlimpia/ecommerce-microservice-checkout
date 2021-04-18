package com.digitalinnovation.ecommercecheckout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.digitalinnovation.ecommercecheckout.model.Checkout;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout,Long> {

    Optional<Checkout> findByCode(String code);
}
