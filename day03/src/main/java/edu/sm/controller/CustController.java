package edu.sm.controller;

import edu.sm.app.dto.CustDto;
import edu.sm.app.service.CustService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/cust")
public class CustController {

    final CustService custService;

    String dir = "cust/";

    @RequestMapping("")
    public String cust(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id) throws Exception {
        CustDto custDto = null;
        custDto = custService.get(id);
        model.addAttribute("cust",custDto);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"detail");
        return "index";
    }
    @RequestMapping("/updateimpl")
    public String updateimpl(Model model,  CustDto custDto
    ) throws Exception {
        custService.modify(custDto);
        return "redirect:/cust/detail?id="+custDto.getCustId();
    }
    @RequestMapping("/deleteimpl")
    public String deleteimpl(Model model, @RequestParam("id") String id
    ) throws Exception {
        custService.del(id);
        return "redirect:/cust/get";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<CustDto> custs = new ArrayList<>();
        custs = custService.get();

        model.addAttribute("custs",custs);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }

}