package com.engeto.GenesisResources.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UserInfoDTOTest {

    @Test
    void GIVEN_userInfoDTO_WHEN_toString_THEN_checked() {
        // GIVEN
        UserInfoDTO dto = new UserInfoDTO("Tomas", "Seva", "123456789012", "someUuid");

        // WHEN
        String toStringResult = dto.toString();

        // THEN
        String expectedString = "UserInfoDTO(id = null, name = Tomas, surname = Seva, personId = 123456789012, uuid = someUuid)";
        assertThat(toStringResult).isEqualTo(expectedString);
    }
}
