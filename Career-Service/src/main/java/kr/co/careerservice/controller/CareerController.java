package kr.co.careerservice.controller;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;
import kr.co.careerservice.service.CareerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j //로깅을 위함
@RequiredArgsConstructor
@PropertySource("classpath:/application.properties")
public class CareerController {

    private final CareerServiceImpl careerService;

    //GET
    @GetMapping("/careers/new")
    public String newCareerForm(){

       return "";
    }


    @PostMapping("/careers")
    public ResponseEntity<CareerEntity> createCareer(@RequestBody @Valid CareerDto.New careerDto){
        CareerEntity created = careerService.newCareer(careerDto);
        return(created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    @GetMapping("/uploadMultipleFiles")
    public String mewDocForm(){

        return "careers/fileUpload";
    }





    // 파일 저장할 위치

}



