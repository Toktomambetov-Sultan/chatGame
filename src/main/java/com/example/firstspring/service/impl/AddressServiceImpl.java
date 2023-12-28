package com.example.firstspring.service.impl;

import com.example.firstspring.dto.AddressDto;
import com.example.firstspring.io.entity.AddressEntity;
import com.example.firstspring.io.entity.AddressRepository;
import com.example.firstspring.io.entity.UserEntity;
import com.example.firstspring.io.entity.UserRepository;
import com.example.firstspring.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public AddressDto getAddress(String addressId) {
        ModelMapper modelMapper = new ModelMapper();
        AddressDto returnValue = new AddressDto();
        AddressEntity address = addressRepository.findByAddressId(addressId);
        if(address != null) {
            returnValue = modelMapper.map(address, AddressDto.class);
        }

        return returnValue;
    }

    @Override
    public List<AddressDto> getAddresses(String userId) {
        ModelMapper modelMapper = new ModelMapper();
        List<AddressDto> returnValue= new ArrayList<>();
        UserEntity userEntity = userRepository.findByUserId(userId);
        if(userEntity == null){
            return returnValue;
        }
        Iterable<AddressEntity> addresses = addressRepository.findAllByUserDetails(userEntity);
        for(AddressEntity address: addresses){
            returnValue.add(modelMapper.map(address,AddressDto.class));
        }
        return returnValue;
    }
}
