package org.garden.springwork;

import org.garden.springwork.order.Order;
import org.garden.springwork.voucher.Voucher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

@Configuration
@ComponentScan(basePackageClasses = {Order.class, Voucher.class})
public class AppConfiguration {

}
