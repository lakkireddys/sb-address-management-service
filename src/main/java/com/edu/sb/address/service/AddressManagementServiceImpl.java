package com.edu.sb.address.service;

import com.edu.sb.address.model.Address;
import com.edu.sb.address.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class AddressManagementServiceImpl implements AddressManagementService{
    Logger logger = LogManager.getLogger(AddressManagementServiceImpl.class);
    private final AddressRepository addressRepository;
    @Override
    public Address addAddress(Address address) {
//        Address address1 = Address.builder().addressLine1("rosebury drive").postCode("NE12 8RG").country("ENGLAND").build();
//        addressRepository.saveAll(List.of(address, address1));
       return addressRepository.save(address);

    }

    @Override
    public Address getAddressByLine1AndLine2(String line1, String line2) {
        logger.info ("input address lines {} and {} received ", line1, line2);
        Address resulantAddress = addressRepository.findByAddressLine1AndAddressLine2(line1, line2);
        logger.info("matched address is {}", ObjectUtils.isEmpty(resulantAddress)?"no Match":resulantAddress.getAddressLine1());
        return resulantAddress;
    }
}
