package com.sam.target.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 28/7/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetails {

    private static final long serialVersionUID = -4766566670571360147L;

    List<Order> orders = new ArrayList<Order>();
    int amountTendered;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getAmountTendered() {
        return amountTendered;
    }

    public void setAmountTendered(Integer amountTendered) {
        this.amountTendered = amountTendered;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetails)) return false;

        OrderDetails that = (OrderDetails) o;

        if (amountTendered != that.amountTendered) return false;
        return !(orders != null ? !orders.equals(that.orders) : that.orders != null);

    }

    @Override
    public int hashCode() {
        int result = orders != null ? orders.hashCode() : 0;
        result = 31 * result + amountTendered;
        return result;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orders=" + orders +
                ", amountTendered=" + amountTendered +
                '}';
    }
}
