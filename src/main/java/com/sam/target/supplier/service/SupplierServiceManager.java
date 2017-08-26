package com.sam.target.supplier.service;

import com.sam.target.model.ServiceType;
import com.sam.target.inventory.ProductInventory;
import com.sam.target.model.ProductDetail;
import com.sam.target.model.ServiceResponse;
import com.sam.target.model.SupplierRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sam on 28/7/17
 */
public class SupplierServiceManager {

    @Autowired
    ProductInventory productInventory;

    public ServiceResponse process(SupplierRequest request) {
        if(request.getServiceType() == ServiceType.CLEAR){
            return productInventory.clear();
        } else if(request.getServiceType() == ServiceType.ADD ||
                request.getServiceType() == ServiceType.MODIFY){
            return productInventory.add(new ProductDetail(request));
        } else if(request.getServiceType() == ServiceType.REMOVE){
            return productInventory.deleteProduct(request.getProduct());
        } else if(request.getServiceType() == ServiceType.DISPLAY){
            return productInventory.displayProductInventory();
        }
        else {
            ServiceResponse serviceResponse = new ServiceResponse();
            serviceResponse.setStatus("OPERATION NOT SUPPORTED FOR SUPPLIER!");
            return serviceResponse;
        }
    }


}


