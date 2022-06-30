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
import java.util.List;

@RestController
@Slf4j //로깅을 위함
@RequiredArgsConstructor
@PropertySource("classpath:/application.properties")
public class CareerController {

    private final CareerServiceImpl careerService;


    //인사 조회 - GET
    @GetMapping("/careers")
    public List<CareerEntity> index(){
        return careerService.showAll();
    }
    //개개인 인사 조회 - GET
    @GetMapping("/careers/{id}")
    public CareerEntity index(@PathVariable Long id){
        return careerService.show(id);
    }

    //인사 등록 - POST
    @PostMapping("/careers")
    public ResponseEntity<CareerEntity> createCareer(@RequestBody @Valid CareerDto.New careerDto){
        CareerEntity created = careerService.newCareer(careerDto);
        return(created != null) ?
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    //인사 수정 - PATCH

    @PatchMapping("/careers/{id}")
    public ResponseEntity<CareerEntity> updateCareer(@PathVariable Long id, @RequestBody CareerDto.New careerDto){
        CareerEntity updated = careerService.update(id,careerDto);
        return (updated != null) ? ResponseEntity.status(HttpStatus.OK).body(updated) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }



    //인사 삭제 - DELETE

    @DeleteMapping("/careers/{id}")
    public ResponseEntity<CareerEntity> delete(@PathVariable Long id){

        CareerEntity deleted = careerService.delete(id);
        return(deleted != null)? ResponseEntity.status(HttpStatus.OK).body(deleted):
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }


    @GetMapping("/uploadMultipleFiles")
    public String mewDocForm(){

        return "careers/fileUpload";
    }





}



