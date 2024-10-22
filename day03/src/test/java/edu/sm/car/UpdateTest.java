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
class UpdateTest {

    @Autowired
    CarService carService;

    @Test
    void contextLoads() {
        // 수정할 차량 정보 생성
        CarDto carDto = CarDto.builder()
                .carId(6) // 수정할 차량의 ID
                .carName("Navy Boat") // 차량 이름 수정
                .carColor("Black") // 차량 색상
                .carDate(new Date()) // 차량 등록 날짜
                .carPrice("20000") // 차량 가격 (정수형으로 변경)
                .carFuel("GASOLINE") // 연료 종류
                .build();

        try {
            // 차량 수정 메서드 호출
            carService.modify(carDto);
            log.info("차량 수정 완료: {}", carDto);
        } catch (Exception e) {
            log.error("차량 수정 중 오류 발생: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
