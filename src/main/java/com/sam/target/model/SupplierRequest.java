package com.sam.target.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * Created by Sam on 28/7/17
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierRequest {

    private static final long serialVersionUID = -4766566675571360199L;

    private ServiceType serviceType;

    private String product;

    private Integer quantity;

    private Integer price;

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierRequest)) return false;

        SupplierRequest that = (SupplierRequest) o;

        if (serviceType != that.serviceType) return false;
        if (!product.equals(that.product)) return false;
        if (!quantity.equals(that.quantity)) return false;
        return price.equals(that.price);

    }

    @Override
    public int hashCode() {
        int result = serviceType.hashCode();
        result = 31 * result + product.hashCode();
        result = 31 * result + quantity.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
