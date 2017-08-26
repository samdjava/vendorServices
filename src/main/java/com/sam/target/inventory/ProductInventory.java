package com.sam.target.inventory;

import com.sam.target.model.*;

import java.util.*;

/**
 * Created by Sam on 28/7/17
 */
public class ProductInventory {

   private Map<String,ProductDetail> productByName = new HashMap<String,ProductDetail>();

   public ProductInventory(){}

   UUID uuid = UUID.randomUUID();

   public synchronized ServiceResponse add(ProductDetail productDetail){
       ServiceResponse response = new ServiceResponse();
       if(productByName.containsKey(productDetail.getProductName())) {
           ProductDetail detail = productByName.get(productDetail.getProductName());
           if(detail.getPrice() == productDetail.getPrice()) {
               int quantity = detail.getQuantity()+productDetail.getQuantity();
               productDetail.setQuantity(quantity);
           }
           else {
               response.setStatus("CANNOT ADD PRODUCT " + productDetail.getProductName()+" BECAUSE EXISTING PRODUCT WITH " +
                       "THE SAME NAME BUT DIFF PRICE EXISTS!! EXISTING PRICE " + detail.getPrice());
               return response;
           }
       }
       productByName.put(productDetail.getProductName(), productDetail);
       response.setStatus("ADDED SUCCESSFULLY");
       return response;
   }

    public synchronized ServiceResponse deleteProduct(String productName){
        ServiceResponse response = new ServiceResponse();
        if(productByName.containsKey(productName)){
            productByName.remove(productName);
        }
        else {
            response.setStatus("CANNOT DELETE PRODUCT. PRODUCT DOES NOT EXIST !");
            return response;
        }
        response.setStatus("DELETED SUCCESSFULLY");
        return response;
    }

    public ServiceResponse displayProductInventory() {
        ServiceResponse response = new ServiceResponse();
        response.setStatus(productByName.toString());
        return response;
    }

    public synchronized ServiceResponse clear(){
        ServiceResponse response = new ServiceResponse();
        productByName.clear();
        response.setStatus("CLEARED INVENTORY");
        return response;
    }

    public synchronized OrderSummary placeOrder(OrderDetails details) {
        int priceSummary =0;
        OrderSummary summary = new OrderSummary();
        List<ProductDetail> productPurchased = new ArrayList<ProductDetail>();
        for(Order order : details.getOrders()){
            if(productByName.containsKey(order.getProductName())){
                ProductDetail productDetail = productByName.get(order.getProductName());
                if(productDetail.getQuantity() > order.getQuantity()){
                    ProductDetail updatedProductDetail = new ProductDetail(productDetail,
                            productDetail.getQuantity()-order.getQuantity());
                    productPurchased.add(updatedProductDetail);
                    priceSummary = priceSummary + productDetail.getPrice()*order.getQuantity();
                }
                else {
                    summary.setStatus("Insufficient Quantity for product " + order.getProductName() + " available "+
                            productDetail.getQuantity());
                    summary.setPurchaseSuccessful(false);
                    return summary;
                }
            }
            else {
                summary.setStatus("Product Not available!!");
                summary.setPurchaseSuccessful(false);
                return summary;
            }
            if(details.getAmountTendered() < priceSummary) {
                summary.setStatus("Amount tendered as payment is less!!");
                summary.setPurchaseSuccessful(false);
                return summary;
            }
        }
        for(ProductDetail product : productPurchased) {
            productByName.put(product.getProductName(),product);
        }
        summary.setStatus(uuid.toString());
        summary.setPurchaseSuccessful(true);
        summary.setBalanceAmount(details.getAmountTendered() - priceSummary);
        summary.setOrderDetail(details);
        return summary;
    }


    public synchronized ServiceResponse deleteOrder(OrderDetails orderDetail) {
        int priceSummary = 0;
        ServiceResponse response = new ServiceResponse();
        for (Order order : orderDetail.getOrders()) {
            if (productByName.containsKey(order.getProductName())) {
                ProductDetail productDetail = productByName.get(order.getProductName());
                productDetail.setQuantity(productDetail.getQuantity() + order.getQuantity());
                priceSummary = priceSummary + productDetail.getPrice()*order.getQuantity();
            } else {
                response.setStatus("Refund Could not be complete! Product "+ order.getProductName()+" no longer sold");
                return response;
            }
        }
        response.setStatus("Deletion Successfull. Refund Amount "+ priceSummary);
        response.setDetails(orderDetail.toString());
        return response;
    }
}
