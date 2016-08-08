package com.example.Purchase_Details;

import com.example.Production_Details.productionItemTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sumi on 2/8/16.
 */
@RestController
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @RequestMapping(value = "/purEntry", method = RequestMethod.POST)
    public purtable purchaseItemEntry(@RequestBody PTable pTable) {
        Date date = new Date();
        String format = "E yyyy.MM.dd 'at' hh:mm:ss a zzz";
        DateFormat dateFormat = new SimpleDateFormat(format);
        String proDate = dateFormat.format(date);

        purtable p = new purtable();

        p.setPurDate(date);
        p.setTax(pTable.tax);
        p.setVendorName(pTable.vendorName);

        Set<purchaseItemTable> items = new HashSet<>();
        String[] item = pTable.getItem();
        int[] quantity = pTable.getQuantity();
        int[] cost = pTable.getCost1();

        for (int i = 0; i < pTable.item.length; i++) {
            purchaseItemTable pur = new purchaseItemTable();

            System.out.println(item[i]);
            System.out.println(cost[i]);
            pur.setPurItem(item[i]);
            pur.setPurItemQuan(quantity[i]);
            pur.setPurItemCost(cost[i]);
            items.add(pur);
        }

        p.setPurItemList(items);

        return purchaseService.purEntry(p, item, quantity);
    }

    @RequestMapping(value = "/purDisplay", method = RequestMethod.POST)
    public List<purtable> purDisplay() {
        return purchaseService.purDisplay();
    }
}