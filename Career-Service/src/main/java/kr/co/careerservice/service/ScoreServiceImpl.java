package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.dto.ScoreDto;
import kr.co.careerservice.domain.entity.CareerEntity;
import kr.co.careerservice.domain.entity.ScoreEntity;
import kr.co.careerservice.repository.CareerRepository;
import kr.co.careerservice.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {


    private final ScoreRepository scoreRepository;
    private final CareerRepository careerRepository;


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

    }}

//    @Override
//    @Transactional
//    public ScoreDto create(String careerId, ScoreDto scoreDto) {
//        //게시글 조회 및 예외 처리
//        CareerEntity careerEntity = careerRepository.findByCareerId(careerId);
//              //예외처리
//        //댓글 엔티티 생성
//        ScoreEntity scoreEntity = ScoreEntity.toEntity(scoreDto);
//
//        //댓글 엔티티를 DB로 저장
//
//        ScoreEntity createdScore = scoreRepository.save(scoreEntity);
//
//        //DTO로 변경하여 반환
//        return ScoreDto.createdScoreDto(createdScore);
//
//
//
//
//    }
