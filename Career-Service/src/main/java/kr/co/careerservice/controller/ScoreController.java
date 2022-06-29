package kr.co.careerservice.controller;

import kr.co.careerservice.domain.dto.ScoreDto;
import kr.co.careerservice.service.ScoreServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j //로깅을 위함
@RequiredArgsConstructor
public class ScoreController {



    private final ScoreServiceImpl scoreService;

    @GetMapping("/scores/new")
    public String newScoreForm(){

        return "scores/scoreNew";
    }

    @PostMapping("/scores/create")
    public String createScore(ScoreDto.New scoreDto){
        log.info("scoreDto"+scoreDto.toString());
        scoreService.newScore(scoreDto);
        return "/careers/scoreNew";
    }



}
