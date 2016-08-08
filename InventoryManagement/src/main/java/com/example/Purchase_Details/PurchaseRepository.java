package com.example.Purchase_Details;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sumi on 2/8/16.
 */
@org.springframework.stereotype.Repository
public interface PurchaseRepository extends JpaRepository<purtable, Long> {
    List<purtable> findByPurId(Long purId);
}
