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
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;

    /**
     * @param newCareer
     * @return
     */
    //엔티티 만들어서 db에 저장해줌
    @Override
    public CareerEntity newCareer(CareerDto.New newCareer) {
       //예외 처리

        CareerEntity careerEntity = CareerEntity.builder()
                .careerId(newCareer.getCareerId())
                .grade(newCareer.getGrade())
                .name(newCareer.getName())
                .period(newCareer.getPeriod())
                .historyId(newCareer.getHistoryId())

                .build();
        if (careerEntity.getId() != null) {
            return null;
        }
        log.info(careerEntity.getGrade());
        return careerRepository.save(careerEntity);
    }



}
