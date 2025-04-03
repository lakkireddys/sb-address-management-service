package com.edu.sb.address.service;

import com.edu.sb.address.model.Address;

public interface AddressManagementService {
    Address addAddress(Address address);
    Address getAddressByLine1AndLine2(String line1, String line2);
}
