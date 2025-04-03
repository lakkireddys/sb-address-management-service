package com.edu.sb.address.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Address {

    //    @SequenceGenerator(name = "address_seq", allocationSize = 2, initialValue = 1000)
    @GeneratedValue( strategy = GenerationType.SEQUENCE)
    @Id
    private Integer addressId;
    private String addressLine1;
    private String addressLine2;
    private String country;
    private String postCode;
    @CreatedDate
    private LocalDateTime createdTime;
    @LastModifiedDate
    private LocalDateTime lastModifiedTime;
}
