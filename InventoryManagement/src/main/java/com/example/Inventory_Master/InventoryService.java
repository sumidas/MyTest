package com.example.Inventory_Master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sumi on 2/8/16.
 */
//@org.springframework.stereotype.Service
    @Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;

    @Transactional
    public intable entry(intable table)
    {
        String name= table.getItemName();
        if (inventoryRepository.findByItemName(name).size()>0)
        {
            intable in= inventoryRepository.findByItemName(name).get(0);
            if (in.getItemName().equals(name))
                return null;
            return null;
        }
        else
        {
            if (inventoryRepository.save(table)!=null)
                return table;
            else
                return null;
        }
    }

    @Transactional
    public intable delete(String name)
    {
        if(inventoryRepository.findByItemName(name).size()>0)
        {
            intable i = inventoryRepository.findByItemName(name).get(0);
            if(i.getItemName().equalsIgnoreCase(name))
            {
                inventoryRepository.delete(i);
                return i;
            }

            return null;
        }
        return null;
    }

    @Transactional
    public List<intable> display()
    {
        return inventoryRepository.findAll();
    }
}
