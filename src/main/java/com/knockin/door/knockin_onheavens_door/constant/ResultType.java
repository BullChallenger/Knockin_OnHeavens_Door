package com.knockin.door.knockin_onheavens_door.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResultType {

    SUCCESS("0000", "Success!"),
    NOT_EXIST("4001", "Your Target Not Exist!"),
    SYSTEM_ERROR("9000", "System Error Occurred!");

    private final String code;
    private final String desc;
}
