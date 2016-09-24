package com.hackathon.speechtotext.mvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
class IndexController
{

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/appoint")
    public String displayRequestPage()
    {

        logger.debug("made it to controller");
        return "page2";

    }


}
