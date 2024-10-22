package edu.sm.car;

import edu.sm.app.dto.CarDto;
import edu.sm.app.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DeleteTest {
    @Autowired
    CarService carService;

    @Test
    void contextLoads() {

        CarDto carDto = CarDto.builder()
                .carId(9)
                .build();
        try {
            carService.del(carDto.getCarId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}