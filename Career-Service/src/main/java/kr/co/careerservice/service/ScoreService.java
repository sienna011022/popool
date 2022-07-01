package kr.co.careerservice.service;

import kr.co.careerservice.domain.dto.ScoreDto;
import kr.co.careerservice.domain.entity.ScoreEntity;

import java.util.List;


public interface ScoreService {

    List<ScoreDto> scores(String careerId);

}
