package edu.sm.controller;

import edu.sm.util.FileUploadUtil;
import edu.sm.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@Slf4j
public class MainController {

    @Value("${app.key.wkey}")
    String wkey;
    @Value("${app.key.wkey2}")
    String wkey2;
    @Value("${app.url.server-url}")
    String serverurl;

    @RequestMapping("/")
    public String main(Model model) {
        log.info("Start Main ,,,,,,");
        return "index";
    }

    @RequestMapping("/chat")
    public String chat(Model model) {
        model.addAttribute("serverurl", serverurl);
        model.addAttribute("center", "chat");
        return "index";
    }

    @RequestMapping("/websocket")
    public String websocket(Model model) {
        model.addAttribute("serverurl", serverurl);
        model.addAttribute("center", "websocket");
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("center", "login");
        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("center", "register");
        return "index";
    }

    @RequestMapping("/about")
    public String about(Model model) {
        model.addAttribute("center", "about");
        return "index";
    }
    @RequestMapping("/webcam")
    public String webcam(Model model) {
        model.addAttribute("center", "webcam");
        return "index";
    }

    @RequestMapping("/wh")
    @ResponseBody
    public Object wh(Model model) throws IOException, ParseException {
        return WeatherUtil.getWeather("108",wkey);
    }

    @RequestMapping("/wh2")
    @ResponseBody
    public Object wh2(Model model) throws IOException, ParseException {
        log.info("------------------- wh2");
        log.info(WeatherUtil.getWeather2("1835848",wkey2).toString());
        return WeatherUtil.getWeather2("1835848",wkey2);
    }
}







