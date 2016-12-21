package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apereo.portal.soffit.model.v1_0.Bearer;
import org.apereo.portal.soffit.service.BearerService;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@CrossOrigin
@RequestMapping("/api/v1")
public class Api {

    @Autowired
    BearerService bearerService;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/status")
    public @ResponseBody String status(@ModelAttribute("token") String token) {
        Bearer bearer = bearerService.parseBearerToken(token);
        logger.error(bearer.getAttributes().get("pidm").get(0));
        return token;
    }
}