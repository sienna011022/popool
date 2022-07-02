package kr.co.careerservice.controller;

import kr.co.careerservice.domain.dto.ScoreDto;
import kr.co.careerservice.domain.entity.ScoreEntity;
import kr.co.careerservice.service.CareerServiceImpl;
import kr.co.careerservice.service.ScoreServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j //로깅을 위함
@RequiredArgsConstructor
public class ScoreController {

    private final CareerServiceImpl careerService;

    private final ScoreServiceImpl scoreService;

    @GetMapping("/careers/score/{careerId}")
    public ResponseEntity<List<ScoreDto>> scores(@PathVariable String careerId){
        List<ScoreDto> dtos = scoreService.scores(careerId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
//    @PostMapping("/careers/score/{careerId}")
//    public ResponseEntity<ScoreDto> create(@PathVariable String careerId,ScoreDto dto){
//        ScoreDto createdDto = scoreService.create(careerId,dto);






}
