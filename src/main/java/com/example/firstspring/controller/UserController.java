package com.example.firstspring.controller;
import com.example.firstspring.dto.AddressDto;
import com.example.firstspring.dto.UserDto;
import com.example.firstspring.expceptions.UserServiceExceptions;
import com.example.firstspring.model.request.UserDetailsRequestModel;
import com.example.firstspring.model.request.UserDetailsUpdateModel;
import com.example.firstspring.model.response.AddressRest;
import com.example.firstspring.model.response.ErrorMessages;
import com.example.firstspring.model.response.UserRest;
import com.example.firstspring.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.firstspring.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;

    @GetMapping(path = "/{id}")
    public  UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();
        UserDto userDto = userService.getUserByUserId(id);
        BeanUtils.copyProperties(userDto,returnValue);

        return returnValue;
    }
    @GetMapping(path = "/{userId}/addresses")
    public List<AddressRest> getUserAddresses(@PathVariable String userId) {
        ModelMapper modelMapper = new ModelMapper();
        List<AddressRest> returnValue = new ArrayList<>();
        List<AddressDto> addresses = addressService.getAddresses(userId);
        for(AddressDto address: addresses){
            returnValue.add(modelMapper.map(address,AddressRest.class));
        }
        return returnValue;
    }
    @GetMapping(path = "/{userId}/addresses/{addressId}")
    public AddressRest getUserSingleAddress(@PathVariable String addressId, @PathVariable String userId) {
        ModelMapper modelMapper = new ModelMapper();
        AddressDto address = addressService.getAddress(addressId);
        AddressRest returnValue  = modelMapper.map(address,AddressRest.class);
        return returnValue;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public List<UserRest> getUsers(@RequestParam(value="page",defaultValue = "1")int page,
                                   @RequestParam(value="limit",defaultValue = "25")int limit) {
        List<UserRest> returnValue= new ArrayList<>();
        List<UserDto> users= userService.getUsers(page,limit);
        for(UserDto userDto: users){
            UserRest userModel = new UserRest();
            BeanUtils.copyProperties(userDto,userModel);
            returnValue.add(userModel);
        }
        return returnValue;
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetail) throws Exception{
        ModelMapper modelMapper = new ModelMapper();
        if(userDetail.getFirstName().isEmpty()||userDetail.getLastName().isEmpty() ||userDetail.getEmail().isEmpty() || userDetail.getPassword().isEmpty()){
            throw new UserServiceExceptions(ErrorMessages.MISSIN_REQUIRED_FIELD.getErrorMessage());
        }
        UserDto userDto =modelMapper.map(userDetail,UserDto.class);
        UserDto createdUser = userService.createUser(userDto);
        UserRest returnValue = modelMapper.map(createdUser,UserRest.class);
        return returnValue;
    }

    @PutMapping(path="/{userId}")
    public UserRest updateUser(@PathVariable String userId, @RequestBody UserDetailsUpdateModel userDetail){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetail, userDto);
        UserDto createdUser = userService.updateUser(userId,userDto);
        UserRest returnValue = new UserRest();
        BeanUtils.copyProperties(createdUser,returnValue);
        return returnValue;
    }

    @DeleteMapping(path = "/{userId}")
    public String deleteUser(@PathVariable String userId){
        userService.deleteUser(userId);
        return "User with userId " + userId + " has been deleted.";
    }
}