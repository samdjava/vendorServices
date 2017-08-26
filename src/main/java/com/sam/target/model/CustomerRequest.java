package com.sam.target.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Sam on 28/7/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRequest {
    private static final long serialVersionUID = -4766568775571360199L;

    OrderDetails orderDetails ;

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerRequest)) return false;
        CustomerRequest that = (CustomerRequest) o;
        return orderDetails.equals(that.orderDetails);
    }

    @Override
    public int hashCode() {
        return orderDetails.hashCode();
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "orderDetails=" + orderDetails +
                '}';
    }
}
