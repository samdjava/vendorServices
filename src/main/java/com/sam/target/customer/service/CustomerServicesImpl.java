package com.sam.target.customer.service;

import com.sam.target.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 28/7/17
 */
public class CustomerServicesImpl implements CustomerService {

    @Autowired
    CustomerServiceManager customerServiceManager;

    public String ping() {
        return "Customer Service up";
    }

    public OrderSummary placeOrder(CustomerRequest request) {
        return customerServiceManager.placeOrder(request);
    }

    public ServiceResponse delete(String orderId) {
        return customerServiceManager.deleteOrder(orderId);
    }

    public CustomerRequest sample() {
        CustomerRequest customerRequest = new CustomerRequest();
        OrderDetails orderDetails = new OrderDetails();
        Order order = new Order();
        order.setQuantity(2);
        order.setProductName("LAYS");
        Order order1 = new Order();
        order1.setQuantity(3);
        order1.setProductName("PEPSI");
        List <Order> orders = new ArrayList<Order>();
        orders.add(order);
        orders.add(order1);
        orderDetails.setOrders(orders);
        customerRequest.setOrderDetails(orderDetails);
        return  customerRequest;
    }


}
