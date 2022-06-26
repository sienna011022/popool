package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;
import kr.co.careerservice.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j //로깅을 위함
@RequiredArgsConstructor
public class careerServiceImpl implements careerService{

    private final CareerRepository careerRepository;

    /**
     *
     * @param newCareer
     */
    //엔티티 만들어서 db에 저장해줌
    @Override
    public void newCareer(CareerDto.New newCareer) {
       //예외 처리

        CareerEntity careerEntity = CareerEntity.builder()
                .careerId(newCareer.getCareerId())
                .period(newCareer.getPeriod())
                .name(newCareer.getName())
                .historyId(newCareer.getHistoryId())
                .grade(newCareer.getGrade())
                .build();

        careerRepository.save(careerEntity);
    }
}
