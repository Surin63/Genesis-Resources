package com.engeto.GenesisResources.model;

import jakarta.validation.constraints.NotNull;
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

public class ContactTypeDTO {

    @Size(max = 255)
    private Long id;

    @Size(max = 255)
    private String type;

}
