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
    @Override
    public CareerEntity update(Long id, CareerDto.New careerDto) {
        CareerEntity careerEntity = CareerEntity.builder()
                .careerId(careerDto.getCareerId())
                .grade(careerDto.getGrade())
                .name(careerDto.getName())
                .period(careerDto.getPeriod())
                .historyId(careerDto.getHistoryId())

                .build();
        log.info("id:{},career:{}",id,careerEntity.toString());

        //엔티티 조회 -id
        CareerEntity target = careerRepository.findById(id).orElse(null);

        //잘못된 요청
        // id != article.getId()
        if(target ==null) {
            //400 잘못된 요청에 대한 응답
            //왜 다르지...? careerEntity 안에 id가 없네...id로 조회하는게 아닌가/ 일단은 구현
            log.info("id{},careerEntity{}",id,careerEntity.getId());

            return null;

        }
        //정상 승인
        target.patch(careerEntity);
        CareerEntity updated = careerRepository.save(target);
        return updated;
    }


    @Override
    public CareerEntity delete(Long id) {
        CareerEntity target = careerRepository.findById(id).orElse(null);
        log.info("삭제할 대상 {}",target.toString());
        if(target == null){
            return null;
        }

        //대상 삭제
        careerRepository.deleteById(id);
        return target;
    }
}
