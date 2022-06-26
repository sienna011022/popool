package kr.co.careerservice.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@ToString
public  class CareerDto {
    @Builder
    @Getter
    @AllArgsConstructor
    public static class New{


        @ApiModelProperty(example = "아이디")
        @NotBlank(message = "아이디를 입력해주세요.")
        private Long careerId;


        @ApiModelProperty(example = "평가등급")
        @NotBlank(message = "등급을 입력해주세요.")
        private String grade;


        @ApiModelProperty(example = "이름")
        @NotBlank(message = "이름를 입력해주세요.")
        private String name;


        @ApiModelProperty(example = "재직 기간")
        @NotBlank(message = "재직 기간을 입력해주세요")
        private String period;


        @ApiModelProperty(example = "블록체인 아이디")
        @NotBlank(message = "블록체인")
        private String historyId;


    }


}