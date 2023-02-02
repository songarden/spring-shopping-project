package org.garden.springwork;

import java.util.List;
import java.util.UUID;

public class Order {
    private final UUID orderid;
    private final UUID customerId;
    private final List<OrderItem> orderItems;
    private Voucher voucher;
    private OrderStatus orderStatus = OrderStatus.ACCEPTED;


    public Order(UUID orderid, UUID customerId, List<OrderItem> orderItems, Voucher voucher) {
        this.orderid = orderid;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.voucher = voucher;
    }

    public long totalAmount(){
        var beforeDiscount = orderItems.stream().map(v -> v.getProductPrice()*v.getQuantity())
                .reduce(0L,Long::sum);
        return voucher.discount(beforeDiscount);
    }



    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
