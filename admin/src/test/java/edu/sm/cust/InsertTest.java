package edu.sm.cust;

import edu.sm.app.dto.CustDto;
import edu.sm.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class InsertTest {
    @Autowired
    CustService custService;

    @Test
    void insertCustomerTest() { // 메서드 이름을 보다 명확하게 변경했습니다.
        CustDto custDto = CustDto.builder()
                .custId("id04") // 고객 ID
                .custPwd("4444") // 고객 비밀번호
                .custName("집좀가자") // 고객 이름
                .build();

        try {
            custService.add(custDto); // 고객 추가 서비스 호출
            log.info("고객이 성공적으로 추가되었습니다: {}", custDto); // 추가 성공 로그
        } catch (Exception e) {
            log.error("고객 추가 중 오류 발생: {}", e.getMessage()); // 오류 발생 시 로그
            throw new RuntimeException(e); // 예외 발생 시 RuntimeException으로 감싸서 던집니다.
        }
    }
}
