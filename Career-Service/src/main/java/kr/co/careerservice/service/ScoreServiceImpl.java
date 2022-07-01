package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.dto.ScoreDto;
import kr.co.careerservice.domain.entity.CareerEntity;
import kr.co.careerservice.domain.entity.ScoreEntity;
import kr.co.careerservice.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {


    private final ScoreRepository scoreRepository;


    public List<ScoreDto> scores(String careerId) {

        // 조회: 댓글 목록
        List<ScoreEntity> scores = scoreRepository.findByCareerId(careerId);
        log.info(scores.toString());
        // 변환: 엔티티 -> DTO
        List<ScoreDto> dtos = new ArrayList<ScoreDto>();
        for (int i = 0; i < scores.size(); i++) {
            ScoreEntity c = scores.get(i);
            ScoreDto dto = ScoreDto.createScoreDto(c);
            dtos.add(dto);
        }
        return dtos;

    }

        // 반환
//
//        return scoreRepository.findByCareerId(careerId)
//                .stream()
//                .map(scoreEntity -> ScoreDto.createScoreDto(scoreEntity))
//                .collect(Collectors.toList());



}
