package com.knockin.door.knockin_onheavens_door.controller;

import com.knockin.door.knockin_onheavens_door.dto.ResponseDTO;
import com.knockin.door.knockin_onheavens_door.dto.ResultObject;

public abstract class AbstractController {

    protected <T> ResponseDTO<T> ok() { return ok(null, ResultObject.getSuccess()); }

    protected <T> ResponseDTO<T> ok(T data) {
        return ok(data, ResultObject.getSuccess());
    }

    protected <T> ResponseDTO<T> ok(T data, ResultObject result) {
        ResponseDTO<T> obj = ResponseDTO.<T>resultDataBuilder()
                .data(data)
                .result(result)
                .build();

        return obj;
    }
}
