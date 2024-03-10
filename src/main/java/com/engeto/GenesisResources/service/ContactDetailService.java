package com.engeto.GenesisResources.service;

import com.engeto.GenesisResources.domain.ContactDetail;
import com.engeto.GenesisResources.model.ContactDetailDTO;
import com.engeto.GenesisResources.repository.ContactDetailRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ContactDetailService {

    private final ContactDetailRepository contactDetailRepository;
    private ModelMapper modelMapper;

    public ContactDetailDTO createContact(ContactDetailDTO contactDetailDTO) {
        ContactDetail contactDetail = convertToDomain(contactDetailDTO);
        contactDetailRepository.save(contactDetail);
        return contactDetailDTO;
    }

    public List<ContactDetailDTO> findAllContactDetailsSortById() {
        final List<ContactDetail> contactDetailList = contactDetailRepository.findAll(Sort.by("id"));
        return contactDetailList.stream().map(this::convertToDto).toList();
    }

    public void delete(Long id) {
        contactDetailRepository.deleteById(id);
    }

    private ContactDetail convertToDomain(ContactDetailDTO dto) {
        ContactDetail contactDetail = modelMapper.map(dto, ContactDetail.class);
        return contactDetail;
    }

    private ContactDetailDTO convertToDto(ContactDetail contactDetail) {
        ContactDetailDTO contactDto = modelMapper.map(contactDetail, ContactDetailDTO.class);
        return contactDto;
    }
}
