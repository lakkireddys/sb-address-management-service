package com.edu.sb.address.repository;

import com.edu.sb.address.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

    Address findByAddressLine1AndAddressLine2(String line1, String line2);
}
