package kr.co.careerservice.controller;

import kr.co.careerservice.domain.dto.CareerDto;
import kr.co.careerservice.domain.entity.CareerEntity;
import kr.co.careerservice.repository.CareerRepository;
import kr.co.careerservice.service.careerService;
import kr.co.careerservice.service.careerServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@Slf4j //로깅을 위함
@RequiredArgsConstructor
public class CareerController {

    @Autowired

    private final careerServiceImpl careerService;

    @GetMapping("/careers/new")
    public String newCareerForm(){

        return "careers/careerNew";
    }


    @PostMapping("/careers/create")
    public String createArticle(CareerDto.New careerDto){
        log.info("careerDto"+careerDto.toString());
        careerService.newCareer(careerDto);
       return "/careers/careerNew";
    }

    @GetMapping("/uploadMultipleFiles")
    public String uploadFile(){

        return "careers/fileUpload";
    }

    @RequestMapping("/uploadMultipleFiles")
    public String fileupload(HttpServletRequest request, @RequestBody List<MultipartFile> files){
        log.info("file"+files);
        try{
            for(int i=0;i<files.size();i++){
                files.get(i).transferTo(new File("C:\\Test_Popook"+files.get(i).getOriginalFilename()));
            }
        }catch (IllegalStateException | IOException e){
            e.printStackTrace();
        }
        return "";
    }


}
