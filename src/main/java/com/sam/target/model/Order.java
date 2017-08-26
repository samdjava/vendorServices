package com.sam.target.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Sam on 28/7/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Order {

    private static final long serialVersionUID = -426566675571360199L;

    String productName;
    Integer quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (!productName.equals(order.productName)) return false;
        return quantity.equals(order.quantity);

    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + quantity.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
