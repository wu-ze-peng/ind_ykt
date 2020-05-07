package com.ykt.ind_ykt.controller;

import com.ykt.ind_ykt.core.ResultBean;
import com.ykt.ind_ykt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("index")
    public String to_index(){
        return "index";
    }

    @RequestMapping("/front/{page}")
    public String page(@PathVariable("page") String page){
        return "front/" + page;
    }
}
