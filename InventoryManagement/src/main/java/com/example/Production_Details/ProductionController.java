package com.example.Production_Details;

//import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by sumi on 2/8/16.
 */
@RestController
public class ProductionController {

    @Autowired
    ProductionService productionService;

    @RequestMapping(value = "/proEntry", method = RequestMethod.POST)
    public protable productionItemEntry(@RequestBody Table table) {
        Date date = new Date();
        String format = "E yyyy.MM.dd 'at' hh:mm:ss a zzz";
        DateFormat dateFormat = new SimpleDateFormat(format);
        String proDate = dateFormat.format(date);

        protable p = new protable();

        p.setProItem(table.proName);
        p.setTotal(table.total);
        p.setProDate(date);

        Set<productionItemTable> items = new HashSet<>();
        String[] item = table.getItem();
        int[] quantity = table.getQuantity();

        for (int i = 0; i < table.item.length; i++) {
            productionItemTable pro = new productionItemTable();

            System.out.println(item[i]);
            pro.setRawItem(item[i]);
            pro.setProItemQuan(quantity[i]);

            items.add(pro);
        }

        p.setProItemList(items);

        return productionService.proEntry(p, item, quantity);
    }

    @RequestMapping(value = "/proDisplay", method = RequestMethod.POST)
    public List<protable> display()
    {
        return productionService.display();
    }

}
