package com.sam.target.customer.service;

import com.sam.target.model.CustomerRequest;
import com.sam.target.model.OrderSummary;
import com.sam.target.model.ServiceResponse;

import javax.ws.rs.*;

/**
 * Created by Sam on 28/7/17
 */

@Path("/api")
@Produces({"application/json"})
@Consumes({"application/json"})
public interface CustomerService {


    @Path("/ping")
    @GET
    String ping();

    @Path("/order")
    @POST
    OrderSummary placeOrder(CustomerRequest request);

    @Path("/order/delete/{orderId}")
    @PUT
    ServiceResponse delete(@PathParam("orderId")String orderId);


    //To Construct request for ordering! Should be removed
    @Path("/sample")
    @GET
    CustomerRequest sample();
}
