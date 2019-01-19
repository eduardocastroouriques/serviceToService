package com.ouriques.serviceToService.service;

import com.ouriques.serviceToService.common.RestTemplateResponseErrorHandler;
import com.ouriques.serviceToService.common.ServiceUrl;
import com.ouriques.serviceToService.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BandService {

    private static RestTemplate restTemplate;

    static {
        restTemplate = new RestTemplate();
    }

    @Autowired
    public BandService(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.errorHandler(new RestTemplateResponseErrorHandler()).build();
    }

    @Cacheable("bands")
    public List<Band> getBands() throws Exception{
        return restTemplate.getForObject(ServiceUrl.RECRUITING_BAND_URL, List.class);
    }

}
