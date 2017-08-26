package com.sam.target.supplier.service;

import com.sam.target.model.ServiceResponse;
import com.sam.target.model.SupplierRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sam on 28/7/17
 */
public class SupplierServicesImpl implements SupplierService {

    @Autowired
    SupplierServiceManager serviceManager;

    public String ping() {
        return "Supplier Services Up!";
    }

    public ServiceResponse serviceRequest(SupplierRequest request) {
        return serviceManager.process(request);
    }

}
