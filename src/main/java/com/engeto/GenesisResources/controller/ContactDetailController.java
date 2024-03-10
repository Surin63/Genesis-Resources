package com.engeto.GenesisResources.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class ContactDetailController {
    private final ContactDetailController contactDetailController;
    @PostMapping("/contactDetail")
    public ResponseEntity<ContactDetailDTO> createContactDetail(@RequestBody ContactDetailDTO contactDetailDTO) {
        ContactDetailDTO createContactDetail = contaDetailService.createContatc(contactDetailDTO);
        return new ResponseEntity<>(createContactDetail, HttpStatus.CREATED);
    }
    @GetMapping("/contactDetails")
    public ResponseEntity<List<ContactDetailDTO>> getAllContactDeatail() {
        List<ContactDetailDTO> allContactDetailList = contactDetailService.findAllContactDetailsSortById();

        if (CollectionsUtils.isEmpty(allContactDetailList)){
            return new ResponseEntity<List<>>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(allContactDetailList, HttpStatus.OK);
        }
    }
}
