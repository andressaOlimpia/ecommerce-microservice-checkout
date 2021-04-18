package com.digitalinnovation.ecommercecheckout.service;

import com.digitalinnovation.ecommercecheckout.event.CheckoutCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import com.digitalinnovation.ecommercecheckout.controller.CheckoutRequest;
import com.digitalinnovation.ecommercecheckout.model.Checkout;
import com.digitalinnovation.ecommercecheckout.repository.CheckoutRepository;
import com.digitalinnovation.ecommercecheckout.streaming.CheckoutCreatedSource;


@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService{

    private final CheckoutRepository checkoutRepository;
    private final CheckoutCreatedSource checkoutCreatedSource;


    @Override
    public Optional<Checkout> create(CheckoutRequest checkoutRequest) {

        final Checkout checkout = Checkout.builder()
                .code(UUID.randomUUID().toString())
                .status(Checkout.Status.CREATED)
                .build();

        final Checkout createdCheckout = checkoutRepository.save(checkout);

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(createdCheckout.getCode())
                .setStatus(createdCheckout.getStatus().name())
                .build();

        Message<CheckoutCreatedEvent> message = MessageBuilder.withPayload(checkoutCreatedEvent).build();

       checkoutCreatedSource.output().send(message);

        return Optional.of(createdCheckout);
    }
}
