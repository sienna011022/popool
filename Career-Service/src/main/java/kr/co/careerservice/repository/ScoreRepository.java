package kr.co.careerservice.repository;

import kr.co.careerservice.domain.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<ScoreEntity,Long> {
}
