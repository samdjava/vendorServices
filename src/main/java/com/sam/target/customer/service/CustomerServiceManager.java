package com.sam.target.customer.service;

import com.sam.target.inventory.ProductInventory;
import com.sam.target.model.CustomerRequest;
import com.sam.target.model.OrderSummary;
import com.sam.target.model.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sam on 28/7/17
 */
public class CustomerServiceManager {

    @Autowired
    ProductInventory productInventory;

    private final Map<String,OrderSummary> orderHistory = new HashMap<String,OrderSummary>();

    public OrderSummary placeOrder(CustomerRequest request){
        OrderSummary summary = productInventory.placeOrder(request.getOrderDetails());
        if(summary.getPurchaseSuccessful()) {
            orderHistory.put(summary.getStatus(), summary);
        }
        return summary;
    }

    public ServiceResponse deleteOrder(String orderId){
        if(orderHistory.containsKey(orderId)){
           return productInventory.deleteOrder(orderHistory.get(orderId).getOrderDetail());
        } else {
            ServiceResponse response = new ServiceResponse();
            response.setStatus("Order id is incorrect!");
            return response;
        }
    }


}
