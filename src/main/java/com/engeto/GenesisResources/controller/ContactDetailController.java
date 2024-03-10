package com.engeto.GenesisResources.controller;

import com.engeto.GenesisResources.model.ContactDetailDTO;
import com.engeto.GenesisResources.service.ContactDetailService;
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

    private final ContactDetailService contactDetailService;
    @PostMapping("/contactDetail")
    public ResponseEntity<ContactDetailDTO> createContactDetail(@RequestBody ContactDetailDTO contactDetailDTO) {
        ContactDetailDTO createContactDetail = contactDetailService.createContact(contactDetailDTO);
        return new ResponseEntity<>(createContactDetail, HttpStatus.CREATED);
    }
    @GetMapping("/contactDetails")
    public ResponseEntity<List<ContactDetailDTO>> getAllContactDeatail() {
        List<ContactDetailDTO> allContactDetailList = contactDetailService.findAllContactDetailsSortById();

        if (CollectionUtils.isEmpty(allContactDetailList)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(allContactDetailList, HttpStatus.OK);
        }
    }
}
