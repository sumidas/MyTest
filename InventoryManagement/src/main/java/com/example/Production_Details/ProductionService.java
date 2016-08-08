package com.example.Production_Details;

import com.example.Inventory_Master.InventoryRepository;
import com.example.Inventory_Master.intable;
import com.example.Item_List.ItemTable;
import com.example.Item_List.ItemTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sumi on 2/8/16.
 */
@Service
public class ProductionService {
    @Autowired
    ProductionRepository productionRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ItemTableRepository itemTableRepository;

    @Transactional
    public protable proEntry(protable p, String[] item, int[] quantity)
    {
        /*if (productionRepository.save(p)==null)
            return null;
        else
        {
            for (int i=0; i<item.length; i++)
            System.out.println(item[i]+"  "+quantity[i]);

            //intable in= new intable();
            for (int i = 0; i < item.length; i++) {
                System.out.println("Inside For");

                if (inventoryRepository.findByItemName(item[i]).size()>0)
                {

                    intable in= inventoryRepository.findByItemName(item[i]).get(0);
                    int balance= in.getCurrBalance();

                    //System.out.println(balance+" " + in.getItemName())

                    in.setCurrBalance(balance-quantity[i]);
                    inventoryRepository.save(in);
                }

            }
            return p;

        }*/
        int f=0;
        for (int i=0; i<item.length; i++)
        {
            if (inventoryRepository.findByItemName(item[i]).size()>0)
            {
                intable in= inventoryRepository.findByItemName(item[i]).get(0);
                int balance= in.getCurrBalance();

                if (balance-quantity[i] <=0)
                {
                    ItemTable it= new ItemTable();

                    if (itemTableRepository.findByItemToPurchase(item[i]).size()>0)
                    {
                        it= itemTableRepository.findByItemToPurchase(item[i]).get(0);
                        int quan= it.getItemQuanToPurchase();
                        it.setItemQuanToPurchase(quan+quantity[i]);
                    }

                    else
                    {
                        it.setItemToPurchase(item[i]);
                        it.setItemQuanToPurchase(quantity[i]);
                    }

                    itemTableRepository.save(it);
                    f=1;
                }
            }
        }
        if (f==1)
            return null;

        for (int i = 0; i < item.length; i++) {
            System.out.println("Inside For");

            if (inventoryRepository.findByItemName(item[i]).size()>0)
            {

                intable in= inventoryRepository.findByItemName(item[i]).get(0);
                int balance= in.getCurrBalance();

                //System.out.println(balance+" " + in.getItemName())

                in.setCurrBalance(balance-quantity[i]);
                inventoryRepository.save(in);
            }

        }

        if (productionRepository.save(p)!=null)
            return p;
        else
            return null;

    }

    @Transactional
    public List<protable> display()
    {
        return productionRepository.findAll();
    }

}
