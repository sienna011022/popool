package kr.co.careerservice.controller;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.dto.ScoreDto;
import kr.co.careerservice.service.careerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j //로깅을 위함
@RequiredArgsConstructor
public class ScoreController {


    @Autowired

    private final careerServiceImpl careerService;

    @GetMapping("/scores/new")
    public String newScoreForm(){

        return "scores/scoreNew";
    }


}
