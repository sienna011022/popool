package kr.co.careerservice.repository;

import kr.co.careerservice.domain.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ScoreRepository extends JpaRepository<ScoreEntity,Long> {
    @Query(value =
            "SELECT * " +
                    "FROM tbl_score " +
                    "WHERE career_id = :careerId",
            nativeQuery = true)
    List<ScoreEntity> findByCareerId(@Param("careerId")String careerId);

}
