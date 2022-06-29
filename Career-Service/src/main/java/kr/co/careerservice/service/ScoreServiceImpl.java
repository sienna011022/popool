package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.ScoreDto;
import kr.co.careerservice.domain.entity.ScoreEntity;
import kr.co.careerservice.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {


    private final ScoreRepository scoreRepository;
    /**
     *
     * @param newScore
     */
    @Override
    public void newScore(ScoreDto.New newScore) {


        ScoreEntity scoreEntity = ScoreEntity.builder()
                .careerId(newScore.getCareerId())
                .evaluatorId(newScore.getEvaluatorId())
                .attendance(newScore.getAttendance())
                .sincerity(newScore.getSincerity())
                .positiveness(newScore.getPositiveness())
                .technical(newScore.getTechnical())
                .cooperative(newScore.getCooperative())
                .build();


        scoreRepository.save(scoreEntity);

    }




}
