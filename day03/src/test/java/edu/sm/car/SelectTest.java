package edu.sm.car;

import edu.sm.app.dto.CarDto; // CarDto를 import 합니다.
import edu.sm.app.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List; // List를 import 합니다.

@SpringBootTest
@Slf4j
class SelectTest {
    @Autowired
    CarService carService;

    @Test
    void contextLoads() {
        try {
            // 전체 차량 정보를 조회합니다.
            List<CarDto> cars = carService.getAll(); // get() 메서드를 getAll()로 변경하여 모든 차량을 조회합니다.

            // 조회된 차량 정보를 로그로 출력합니다.
            for (CarDto car : cars) {
                log.info("차량 정보: {}", car); // 각 차량 정보를 로그에 출력합니다.
            }
        } catch (Exception e) {
            log.error("차량 조회 중 오류 발생: {}", e.getMessage()); // 오류 발생 시 로그에 기록합니다.
            throw new RuntimeException(e);
        }
    }
}
