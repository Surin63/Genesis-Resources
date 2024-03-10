package com.engeto.GenesisResources.model;

import com.engeto.GenesisResources.domain.ContactType;
import com.engeto.GenesisResources.domain.UserInfo;
import jakarta.validation.constraints.Size;
import jakarta.websocket.server.ServerEndpoint;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ContactDetailDTO {

    private Long id;

    @Size(max = 255)
    private UserInfo userId;

    @Size(max = 255)
    private ContactType typeId;

    @Size(max = 255)
    private String value;
}
