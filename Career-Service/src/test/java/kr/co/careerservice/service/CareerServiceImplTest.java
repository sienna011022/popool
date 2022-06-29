package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.*;
@SpringBootTest
public class CareerServiceImplTest {
    @Autowired
    CareerService careerService;
    @Test
    public void career_등록_성공() {
        String careerId = "idididid";
        String grade = "gold";
        String name = "sungyoob";
        String period = "3years";
        String historyId = "hisididid";


        CareerDto.New dto = new CareerDto.New(careerId,grade,name,period,historyId);
        CareerEntity expected = new CareerEntity(careerId,grade,name,period,historyId);


        CareerEntity career = careerService.newCareer(dto);
        Assertions.assertThat(expected.toString()).isEqualTo(career.toString());
    }
}