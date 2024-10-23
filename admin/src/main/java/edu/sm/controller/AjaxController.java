package edu.sm.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/ajax")
public class AjaxController {

    String dir = "ajax/";

    @RequestMapping("")
    public String ajax(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/ajax1")
    public String js1(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"ajax1");
        return "index";
    }
    @RequestMapping("/ajax2")
    public String js2(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"ajax2");
        return "index";
    }
    @RequestMapping("/ajax3")
    public String js3(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"ajax3");
        return "index";
    }
}