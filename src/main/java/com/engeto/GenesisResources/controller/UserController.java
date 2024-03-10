package com.engeto.GenesisResources.controller;


import com.engeto.GenesisResources.model.UserInfoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserInfoService userInfoService;

    public UserController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/user")
    public ResponseEntity<UserInfoDTO> createUser(@RequestBody UserInfoDTO userInfoDTO) {
        UserInfoDTO createdUserInfo = userInfoService.createUser(userInfoDTO);
        return new ResponseEntity<>(createdUserInfo, HttpStatus.CREATED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserInfoDTO> getUsersById(@PathVariable Long id, RequestParam(name = "detail", defaultValue = "false") boolean detail) {
        UserInfoDTO userInfoDTO;
        if (detail) {
            userInfoById = userInfoService.getUserByIdDetail(id);
        }else {
            userInfoById = userInfoService.getUserById(id);
        }
        if (userInfoById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(userInfoById, HttpStatus.OK);
        }

    }
    @GetMapping("/users")
    public ResponseEntity<List<UserInfoDTO>> getAllSortedById(@RequestParam(name = "detail", defaultValue = "false") boolean detail){
        List<UserInfoDTO> usersList;
        if (detail){
            usersList = userInfoService.findAllUsersDetails();
        }else {
            usersList = userInfoService.findAllUsers();
        }
        if (CollectionUtils.isEmpty(usersList)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(usersList, HttpStatus.OK);
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<HttpStatus> updateUserById(@PathVariable("id") Long id, @ResponseBody UserInfoDTO updateUserInfoDTO){
        if(userInfoService.getUserByIdDetail(id) != null){
            userInfoService.updateUserById(id, updateUserInfoDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userInfoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
