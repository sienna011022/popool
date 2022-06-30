package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;
import kr.co.careerservice.repository.CareerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j //로깅을 위함
@RequiredArgsConstructor
public class CareerServiceImpl implements CareerService {

    private final CareerRepository careerRepository;


    @Override
    public List<CareerEntity> showAll(){
        return careerRepository.findAll();

    }
    @Override
    public CareerEntity show(Long id) {
        return careerRepository.findById( id).orElse(null);
    }

    /**
     * @param newCareer
     *
     */
    @Override
    public CareerEntity newCareer(CareerDto.New newCareer) {

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
        log.info("등록대상:{}",careerEntity.toString());
        return careerRepository.save(careerEntity);
    }


}
