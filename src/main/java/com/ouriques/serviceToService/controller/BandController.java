package com.ouriques.serviceToService.controller;

import com.ouriques.serviceToService.builder.ResponseBuilder;
import com.ouriques.serviceToService.model.Band;
import com.ouriques.serviceToService.service.BandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class BandController {

    private final static Logger LOGGER = LoggerFactory.getLogger(BandController.class);

    @Autowired
    private BandService bandService;

    @GetMapping
    public ResponseEntity<?> get() {

        List<Band> bandList = null;

        try {
            bandList = bandService.getBands();
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseBuilder().build(e));
        }

        return ResponseEntity.ok().body(bandList);
    }
}
