package com.knockin.door.knockin_onheavens_door.exception;

import com.knockin.door.knockin_onheavens_door.constant.ResultType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private String code;
    private String desc;
    private String extraMessage;

    public BaseException(ResultType resultType) {
        super(resultType.getCode());
        this.code = resultType.getCode();
        this.desc = resultType.getDesc();
    }

    public BaseException(ResultType resultType, String extraMessage) {
        super(resultType.getDesc() + " - " + extraMessage);
        this.code = resultType.getCode();
        this.desc = resultType.getDesc();
        this.extraMessage = extraMessage;
    }
}
