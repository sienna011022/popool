package kr.co.careerservice.repository;

import kr.co.careerservice.domain.entity.CareerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CareerRepository extends JpaRepository<CareerEntity,Long> {
    @Query(value =
            "SELECT * " +
                    "FROM tbl_career " +
                    "WHERE career_id = :careerId",
            nativeQuery = true
    )
   CareerEntity findByCareerId(@Param("careerId")String careerId);

    @Query(value =
            "DELETE * " +
                    "FROM tbl_career " +
                    "WHERE career_id = :careerId",
            nativeQuery = true
    )
    CareerEntity deleteByCareerId(@Param("careerId")String careerId);
}
