package kr.co.careerservice.domain.entity;

import kr.co.careerservice.domain.shared.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_score")
@Getter
@Entity
public class ScoreEntity extends BaseEntity {


    @Column(name = "careerId", unique = true, nullable = false, length = 100)
    private String careerId;
    @Column(name = "evaluatorId", nullable = true, length = 100)
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
    public ScoreEntity( String careerId, String evaluatorId, int attendance, int sincerity, int positiveness, int technical, int cooperative) {

        this.careerId = careerId;
        this.evaluatorId = evaluatorId;
        this.attendance = attendance;
        this.sincerity = sincerity;
        this.positiveness = positiveness;
        this.technical = technical;
        this.cooperative = cooperative;
    }


}
