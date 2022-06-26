package kr.co.careerservice.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.invoke.MethodHandles;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_career")
@Getter
@Entity
public class CareerEntity {


    @Id
    @GeneratedValue
    @Column(name = "careerId", unique = true, nullable = false, length = 100)
    private Long careerId;
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column(name = "period", nullable = false, length = 100)
    private String period;
    @Column(name = "grade", nullable = false, length = 100)
    private String grade;
    @Column(name = "historyId", nullable = false, length = 100)
    private String historyId;

    @Builder
    public CareerEntity(Long careerId, String name, String period, String grade, String historyId) {
        this.careerId = careerId;
        this.name = name;
        this.period = period;
        this.grade = grade;
        this.historyId = historyId;
    }

}
