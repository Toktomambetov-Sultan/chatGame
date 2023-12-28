package com.example.firstspring.service;

import com.example.firstspring.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto getAddress(String addressId);
    List<AddressDto> getAddresses(String userId);
}
