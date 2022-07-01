package kr.co.careerservice.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import kr.co.careerservice.domain.shared.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_score")
@Getter
@Entity
public class ScoreEntity extends BaseEntity  {



    @ManyToOne
    @JoinColumn(name = "career_id",referencedColumnName = "career_id")
    private CareerEntity careerId;
    @Column(name = "evaluator_id", nullable = true, length = 100)
    private String evaluatorId;
    @Column(name = "attendance", nullable = true, length = 100)
    private int attendance;
    @Column(name = "sincerity", nullable = true, length = 100)
    private int sincerity;
    @Column(name = "positiveness", nullable = true, length = 100)
    private int positiveness;
    @Column(name = "technical", nullable = true, length = 100)
    private int technical;
    @Column(name = "cooperative", nullable = true, length = 100)
    private int cooperative;


    @Builder
    public ScoreEntity(CareerEntity careerId, String evaluatorId, int attendance, int sincerity, int positiveness, int technical, int cooperative) {
        this.careerId = careerId;
        this.evaluatorId = evaluatorId;
        this.attendance = attendance;
        this.sincerity = sincerity;
        this.positiveness = positiveness;
        this.technical = technical;
        this.cooperative = cooperative;
    }


}
