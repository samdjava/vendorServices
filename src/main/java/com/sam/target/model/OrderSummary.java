package com.sam.target.model;

/**
 * Created by Sam on 28/7/17
 */
public class OrderSummary {

    Integer balanceAmount;
    OrderDetails orderDetail;
    Boolean purchaseSuccessful;
    String status;

    public Integer getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Integer balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public OrderDetails getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetails orderDetail) {
        this.orderDetail = orderDetail;
    }

    public Boolean getPurchaseSuccessful() {
        return purchaseSuccessful;
    }

    public void setPurchaseSuccessful(Boolean purchaseSuccessful) {
        this.purchaseSuccessful = purchaseSuccessful;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderSummary)) return false;

        OrderSummary that = (OrderSummary) o;

        if (balanceAmount != null ? !balanceAmount.equals(that.balanceAmount) : that.balanceAmount != null)
            return false;
        if (!orderDetail.equals(that.orderDetail)) return false;
        return purchaseSuccessful.equals(that.purchaseSuccessful);

    }

    @Override
    public int hashCode() {
        int result = balanceAmount != null ? balanceAmount.hashCode() : 0;
        result = 31 * result + orderDetail.hashCode();
        result = 31 * result + purchaseSuccessful.hashCode();
        return result;
    }
}
