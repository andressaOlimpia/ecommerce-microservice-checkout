package com.digitalinnovation.ecommercecheckout.config;

import com.digitalinnovation.ecommercecheckout.streaming.CheckoutCreatedSource;
import com.digitalinnovation.ecommercecheckout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
