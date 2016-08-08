package com.example.Purchase_Details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sumi on 3/8/16.
 */
@Repository
public interface purchaseItemRepository extends JpaRepository<purchaseItemTable, Long>{
    List<purchaseItemTable> findByPurItemId(Long purItemId);
}
