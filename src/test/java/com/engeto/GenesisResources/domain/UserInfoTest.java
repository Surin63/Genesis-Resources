package com.engeto.GenesisResources.domain;

import org.assertj.core.api.Assertions;
import org.h2.command.dml.MergeUsing;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserInfoTest {

    @Test
    void GIVEN_userInfo_WHEN_toString_THEN_checked() {
        // GIVEN
        UserInfo userInfo = new UserInfo("Tomas", "Seva", "123456789012", "someUuid");

        // WHEN
        String toStringResult = userInfo.toString();

        // THEN
        String expectedString = "UserInfo(id = null, name = Tomas, surname = Seva, personId = 123456789012, uuid = someUuid)";
        Assertions.assertThat(toStringResult).isEqualTo(expectedString);
    }

}
