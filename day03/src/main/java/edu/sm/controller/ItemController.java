package edu.sm.controller;

import edu.sm.app.dto.Item;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/item")
public class ItemController {

    String dir = "item/";

    @RequestMapping("")
    public String item(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model) {
        List<Item> items = new ArrayList<>();
        items.add(Item.builder().id(1).name("KORONE").price(10000).imgname("p1.jpg").regdate(new Date()).build());
        items.add(Item.builder().id(2).name("SAKURA MIKO").price(20000).imgname("p2.jpg").regdate(new Date()).build());
        items.add(Item.builder().id(3).name("OTONOSE KANADE").price(500000).imgname("p3.jpg").regdate(new Date()).build());
        items.add(Item.builder().id(4).name("USADA PEKORA").price(40000).imgname("p4.jpg").regdate(new Date()).build());
        items.add(Item.builder().id(5).name("HOUSHOU MARIN").price(3440000).imgname("p5.jpg").regdate(new Date()).build());

        model.addAttribute("items",items);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }

}