package kr.co.careerservice.repository;

import kr.co.careerservice.domain.entity.CareerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<CareerEntity,Long> {


}
