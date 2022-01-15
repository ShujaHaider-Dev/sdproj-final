package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class RedirectController {
    @RequestMapping(value = "/{[path:[^\\.]*}")
    public String redirect() {
        return "redirect:/home";
    }
}
