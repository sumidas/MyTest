package com.example.Inventory_Master;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sumi on 2/8/16.
 */
//@org.springframework.stereotype.Repository
    @Repository
public interface InventoryRepository extends JpaRepository<intable, Long> {
    List<intable> findByInvenId(Long invenId);
    List<intable> findByItemName(String itemName);
}

