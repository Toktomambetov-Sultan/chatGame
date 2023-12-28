package com.example.firstspring.io.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name="users")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 123;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailVerifictionToken() {
        return emailVerifictionToken;
    }

    public void setEmailVerifictionToken(String emailVerifictionToken) {
        this.emailVerifictionToken = emailVerifictionToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }

    @Id
    @GeneratedValue
    private Long id;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable=true)
    private String userId;

    @Column(nullable = true,length = 50)
    private String firstName;

    @Column(nullable = true,length = 50)
    private String lastName;

    @Column(nullable = true,length = 120)
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    @Column(nullable = true)
    private String encryptedPassword;

    private String emailVerifictionToken;

    @Column(nullable = true)
    private Boolean emailVerificationStatus = false;


    @OneToMany(mappedBy = "userDetails",cascade = CascadeType.PERSIST)
    private List<AddressEntity> addresses = new ArrayList<>();

    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }
}
