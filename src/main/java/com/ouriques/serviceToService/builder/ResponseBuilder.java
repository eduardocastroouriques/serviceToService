package com.ouriques.serviceToService.builder;

import com.ouriques.serviceToService.model.CustomResponse;

public class ResponseBuilder {

    public CustomResponse build(Exception e){
        return new CustomResponse(e.getMessage());
    }
}
