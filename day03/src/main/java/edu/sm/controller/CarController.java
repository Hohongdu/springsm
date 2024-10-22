package edu.sm.controller;

import edu.sm.app.dto.CarDto;
import edu.sm.app.dto.CustDto;
import edu.sm.app.dto.Item;
import edu.sm.app.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/car")
public class CarController {
    private final CarService carService;
    String dir = "car/";

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("")
    public String chart(Model model) {
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
    public String get(Model model) throws Exception {
        List<CarDto> cars = carService.get();
        model.addAttribute("cars",cars);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }
    @RequestMapping("/getAll") // @RequestMapping을 사용하여 경로를 설정합니다.
    public String getAll(Model model) throws Exception {
        List<CarDto> cars = carService.getAll(); // 모든 차량을 조회합니다.
        model.addAttribute("cars", cars); // 모델에 차량 정보를 추가합니다.
        model.addAttribute("left", dir + "left"); // 좌측 메뉴 추가
        model.addAttribute("center", dir + "getAll"); // 중앙 콘텐츠로 getAll 페이지 추가
        return "index"; // index 페이지를 반환합니다.
    }

    @RequestMapping("/detail")
    public String detail(
            Model model,
            @RequestParam("id") int id
    ) throws Exception {
        CarDto carDto = carService.get(id);
        model.addAttribute("car", carDto);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"detail");
        return "index";
    }
    @RequestMapping("/update_impl")
    public String updateImpl(
            Model model,
            CarDto carDto
    ) throws Exception {
        carService.modify(carDto);
        return "redirect:/car/detail?id="+carDto.getCarId();
    }
    @RequestMapping("/delete_impl")
    public String deleteImpl(Model model,  @RequestParam("id") int id
    ) throws Exception {
        carService.del(id);
        return "redirect:/car/get";
    }

    @RequestMapping("/search")
    public String search(Model model,  @RequestParam("carName") String name
    ) throws Exception {
        List<CarDto> cars = carService.findByName(name);
        model.addAttribute("cars",cars);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }
}