package com.digitalinnovation.ecommercecheckout.listener;

import com.digitalinnovation.ecommerce.payment.event.PaymentCreatedEvent;
import com.digitalinnovation.ecommercecheckout.model.Checkout;
import com.digitalinnovation.ecommercecheckout.repository.CheckoutRepository;
import com.digitalinnovation.ecommercecheckout.streaming.PaymentPaidSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepository checkoutRepository;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
        final Checkout checkout = checkoutRepository
                .findByCode(event.getCheckoutCode().toString()).orElseThrow();
        checkout.setStatus(Checkout.Status.APPROVED);
        checkoutRepository.save(checkout);
    }
}
