package com.jac.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/")
    public String getindex() {
        return "index.html";
    }

    @PostMapping("/")
    public String postindex() {
        return "index.html";
    }

    @GetMapping("/error")
    public String getError() {
        return "index.html";
    }

    @PostMapping("/error")
    public String postError() {
        return "index.html";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {

        return "Hello!";
    }

    @RequestMapping("/manager/hello")
    @ResponseBody
    public String admin() {

        return "admin!";
    }

    @RequestMapping("/user/hello")
    @ResponseBody
    public String user() {

        return "user!";
    }

    @RequestMapping("/failed")
    @ResponseBody
    public String failed() {

        return "failed!";
    }

}
