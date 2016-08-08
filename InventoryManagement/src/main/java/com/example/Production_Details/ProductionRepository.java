package com.example.Production_Details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sumi on 2/8/16.
 */
@Repository
public interface ProductionRepository extends JpaRepository<protable, Long> {
    List<protable> findByProId(Long proId);
}
