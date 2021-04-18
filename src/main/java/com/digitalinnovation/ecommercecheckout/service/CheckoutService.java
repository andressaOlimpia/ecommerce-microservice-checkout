package com.digitalinnovation.ecommercecheckout.service;

import java.util.Optional;

import com.digitalinnovation.ecommercecheckout.controller.CheckoutRequest;
import com.digitalinnovation.ecommercecheckout.model.Checkout;


public interface CheckoutService {

    Optional<Checkout> create(CheckoutRequest checkoutRequest);
}
