package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;

public interface CareerService {

   CareerEntity newCareer(CareerDto.New newCareer);


}
