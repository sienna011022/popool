package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;

import java.util.List;

public interface CareerService {

    List<CareerEntity> showAll();

    CareerEntity show(Long id);
   CareerEntity newCareer(CareerDto.New newCareer);


}
