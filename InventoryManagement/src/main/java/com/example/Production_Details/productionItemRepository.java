package com.example.Production_Details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sumi on 3/8/16.
 */
@Repository
public interface productionItemRepository extends JpaRepository <productionItemTable, Long>{
    List<productionItemTable> findByProItemId(Long proItemId);

}
