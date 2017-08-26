package com.sam.target.model;

/**
 * Created by Sam on 28/7/17
 */
public class ProductDetail {

    private String productName;
    private Integer quantity;
    private Integer price;

    public ProductDetail(){}

    public ProductDetail(ProductDetail productDetail,int quantity){
        this.setProductName(productDetail.getProductName());
        this.setPrice(productDetail.getPrice());
        this.setQuantity(quantity);
    }

    public ProductDetail(SupplierRequest request){
        this.setProductName(request.getProduct());
        this.setPrice(request.getPrice());
        this.setQuantity(request.getQuantity());
    }

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDetail)) return false;

        ProductDetail that = (ProductDetail) o;

        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        return !(price != null ? !price.equals(that.price) : that.price != null);

    }

    @Override
    public int hashCode() {
        int result = productName != null ? productName.hashCode() : 0;
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
