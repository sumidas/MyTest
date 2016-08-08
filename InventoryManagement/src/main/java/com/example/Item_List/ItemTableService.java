package com.example.Item_List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sumi on 5/8/16.
 */
@Service
public class ItemTableService {

    @Autowired
    ItemTableRepository itemTableRepository;

    @Transactional
    public ItemTable entry (ITable iTable)
    {
        ItemTable it= new ItemTable();
        int f=0;
        for (int i=0; i<iTable.getItem().length; i++)
        {
             it = new ItemTable();
            if (itemTableRepository.findByItemToPurchase(iTable.item[i]).size()>0)
            {
                it= itemTableRepository.findByItemToPurchase(iTable.item[i]).get(0);
                int quan= it.getItemQuanToPurchase();
                it.setItemQuanToPurchase(quan+iTable.quantity[i]);
            }

            else
            {
                it.setItemToPurchase(iTable.item[i]);
                it.setItemQuanToPurchase(iTable.quantity[i]);
            }
            itemTableRepository.save(it);
            f = 1;
        }

        if (f==0)
         return null;

        return it;
    }
    @Transactional
    public List<ItemTable> display()
    {
        return itemTableRepository.findAll();
    }
}
