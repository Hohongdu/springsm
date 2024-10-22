package edu.sm.car;

import edu.sm.app.dto.CarDto;
import edu.sm.app.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
class InsertTest {
    @Autowired
    CarService carService;

    @Test
    void contextLoads() {
        CarDto carDto =
                CarDto.builder().carName("Nice Boat").carColor("White").carDate(new Date()).carPrice("20000").carFuel("GAS").build();
        try {
            carService.add(carDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}