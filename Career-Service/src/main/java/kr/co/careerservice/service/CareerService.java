package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;

import java.util.ArrayList;
import java.util.List;

public interface CareerService {

    List<CareerEntity> showAll();

   CareerEntity show(String careerId);
   CareerEntity newCareer(CareerDto.New newCareer);

    CareerEntity update(String careerId, CareerDto.New careerDto);
    CareerEntity delete(String careerId);
}
