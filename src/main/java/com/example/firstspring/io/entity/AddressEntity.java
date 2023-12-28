package com.example.firstspring.io.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity(name="addresses")
public class AddressEntity implements Serializable {
    private static final long serialVersionUID = -2677386093190364437L;

    @Id
    @GeneratedValue
    private Long id;


    public UserEntity getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserEntity userDetails) {
        this.userDetails = userDetails;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    @ManyToOne
    @JoinColumn(name = "users_id")
    private UserEntity userDetails;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    @Column(length = 50,nullable = false)
    private String addressId;
    @Column(length = 50,nullable = false)
    private String country;

    @Column(length = 7,nullable = false)
    private String postalCode;

    @Column(length = 100,nullable = false)
    private String streetName;
    @Column(length = 30,nullable = false)
    private String city;
    @Column(length = 10,nullable = false)
    private String type;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
}
