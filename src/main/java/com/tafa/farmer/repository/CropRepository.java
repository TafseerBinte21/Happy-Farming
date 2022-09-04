package com.tafa.farmer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.tafa.farmer.models.crop;

@Repository
public interface CropRepository extends JpaRepository<crop, Long> {

	crop findByname(String name);

	Optional<crop> findById(Long id);

	// Custom query
	@Query(value = "select * from croplist s where s.name like :keyword%", nativeQuery = true)
	List<crop> findByKeyword(@Param("keyword") String keyword);
	
//	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM game_list s WHERE s.id = ?1")
//    Boolean isGameExitsById(Long id);
}
