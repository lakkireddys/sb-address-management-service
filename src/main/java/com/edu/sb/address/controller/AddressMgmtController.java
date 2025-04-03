package com.edu.sb.address.controller;

import com.edu.sb.address.model.Address;
import com.edu.sb.address.service.AddressManagementService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AddressMgmtController {
    private final AddressManagementService managementService;
    Logger log = LogManager.getLogger(AddressMgmtController.class);

    @RequestMapping(method = RequestMethod.POST, path="/add-address")
    public ResponseEntity<Address> processNewAddress(@RequestBody Address address){
        log.info("processing address");
        return ResponseEntity.ok(managementService.addAddress(address));
    }
    @RequestMapping(method = RequestMethod.POST, path="/create-customer-with-address")
    public ResponseEntity<Address> processUnMatchedAddress(@RequestBody Address address){
        log.info("processing unmatched address");
        Address matchecdAddress = managementService.getAddressByLine1AndLine2(address.getAddressLine1(), address.getAddressLine2());
        return matchecdAddress != null?ResponseEntity.ok(matchecdAddress): ResponseEntity.ok(managementService.addAddress(address));
    }

    @GetMapping("/get-address-by-lines")
    public Address retrieveAddressForLine1(@RequestParam("line1") String line1, @RequestParam("line2") String line2){
        log.info("fetching address");
        return managementService.getAddressByLine1AndLine2(line1, line2);
    }

}
