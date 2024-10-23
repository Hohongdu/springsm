package edu.sm.controller;

import com.github.pagehelper.PageInfo;
import edu.sm.app.dto.ItemDto;
import edu.sm.app.dto.Search;
import edu.sm.app.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;
    private final String dir = "item/";

    @RequestMapping("")
    public String item(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "center");
        return "index";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "add");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<ItemDto> items = itemService.get(); // 모든 아이템 가져오기
        model.addAttribute("items", items);
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "get");
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") String id) throws Exception {
        ItemDto itemDto = itemService.get(id);
        model.addAttribute("item", itemDto);
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "detail");
        return "index";
    }

    @RequestMapping("/updateimpl")
    public String updateimpl(ItemDto itemDto) throws Exception {
        itemService.modify(itemDto);
        return "redirect:/item/detail?id=" + itemDto.getItemId();
    }

    @RequestMapping("/deleteimpl")
    public String deleteimpl(@RequestParam("id") String id) throws Exception {
        itemService.del(id);
        return "redirect:/item/get";
    }

    @RequestMapping("/getpage")
    public String getpage(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo, Model model) throws Exception {
        PageInfo<ItemDto> p = new PageInfo<>(itemService.getPage(pageNo), 5); // 5: 한화면에 출력되는 개수
        model.addAttribute("cpage", p);
        model.addAttribute("target", "/item");
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "page");
        return "index";
    }

    @RequestMapping("/search")
    public String search(Model model) {
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "search");
        return "index";
    }

    @RequestMapping("/findimpl")
    public String findimpl(Model model, Search search, @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) throws Exception {
        PageInfo<ItemDto> p = new PageInfo<>(itemService.getFindPage(pageNo, search), 5); // 5: 하단 네비게이션 개수
        model.addAttribute("cpage", p);
        model.addAttribute("target", "item");
        model.addAttribute("search", search);
        model.addAttribute("left", dir + "left");
        model.addAttribute("center", dir + "search");
        return "index";
    }
}
