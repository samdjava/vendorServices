package com.sam.target.supplier.service;

import com.sam.target.model.SupplierRequest;
import com.sam.target.model.ServiceResponse;

import javax.ws.rs.*;

/**
 * Created by Sam on 28/7/17
 */

@Path("/api")
@Produces({"application/json"})
@Consumes({"application/json"})
public interface SupplierService {


    @Path("/ping")
    @GET
    String ping();

    @Path("/products")
    @POST
    ServiceResponse serviceRequest(SupplierRequest request);

}
