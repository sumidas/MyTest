package com.example.Item_List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sumi on 5/8/16.
 */
@Repository
public interface ItemTableRepository extends JpaRepository<ItemTable, Long>{
    List<ItemTable> findById(Long Id);
    List<ItemTable> findByItemToPurchase(String toPurItem);
}
