package com.knockin.door.knockin_onheavens_door.dto;

import com.knockin.door.knockin_onheavens_door.constant.ResultType;
import com.knockin.door.knockin_onheavens_door.exception.BaseException;

import java.io.Serializable;

public class ResultObject implements Serializable {

    public String code;

    public String desc;

    public ResultObject(ResultType resultType) {
        this.code = resultType.getCode();
        this.desc = resultType.getDesc();
    }

    public ResultObject(ResultType resultType, String message) {
        this.code = resultType.getCode();
        this.desc = message;
    }

    public ResultObject(BaseException e) {
        this.code = e.getCode();
        this.desc = e.getDesc();
    }

    public static ResultObject getSuccess() {
        return new ResultObject(ResultType.SUCCESS);
    }
}
