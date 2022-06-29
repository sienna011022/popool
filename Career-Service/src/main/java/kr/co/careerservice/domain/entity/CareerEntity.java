package kr.co.careerservice.domain.entity;

import com.fasterxml.jackson.databind.ser.Serializers;
import kr.co.careerservice.domain.shared.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.lang.invoke.MethodHandles;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_career")
@Getter
@ToString
@Entity
public class CareerEntity extends BaseEntity {


    @Column(name = "career_id", unique = true, nullable = false, length = 100)
    private String careerId;
    @Column(name = "grade", nullable = true, length = 100)
    private String grade;
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    @Column(name = "period", nullable = true, length = 100)
    private String period;

    @Column(name = "history_id", nullable = true, length = 100)
    private String historyId;



    @Builder
    public CareerEntity(String careerId,String grade, String name, String period, String historyId) {
        this.careerId = careerId;
        this.grade = grade;
        this.name = name;
        this.period = period;
        this.historyId = historyId;

    }

}
