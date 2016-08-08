package com.example.Purchase_Details;

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
public class PurchaseService {
    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    ItemTableRepository itemTableRepository;

    @Transactional
    public purtable purEntry(purtable p, String[] item, int[] quantity)
    {
        if(purchaseRepository.save(p)==null)
            return null;
        else
        {
            System.out.println("Outside the For");
            for (int i = 0; i < item.length; i++) {
                System.out.println("Inside For");

                if (inventoryRepository.findByItemName(item[i]).size()>0)
                {

                    intable in= inventoryRepository.findByItemName(item[i]).get(0);
                    int balance= in.getCurrBalance();

                    //System.out.println(balance+" " + in.getItemName());

                    in.setCurrBalance(balance+quantity[i]);
                    inventoryRepository.save(in);



                    ItemTable it = itemTableRepository.findByItemToPurchase(item[i]).get(0);
                    balance = it.getItemQuanToPurchase();
                    if (balance-quantity[i]>0)
                    {
                        it.setItemQuanToPurchase(balance-quantity[i]);
                    }
                    else
                     itemTableRepository.delete(it);

                }

            }
            return p;
        }
    }

    @Transactional
    public List<purtable> purDisplay()
    {
        return purchaseRepository.findAll();
    }
}
