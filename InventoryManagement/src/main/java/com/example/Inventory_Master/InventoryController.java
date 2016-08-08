package com.example.Inventory_Master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sumi on 2/8/16.
 */
@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @RequestMapping(value = "/entry", method = RequestMethod.GET)
    public intable inventoryItemEntry(@RequestParam("name") String name, @RequestParam("measure") String measure, @RequestParam("cost") int cost,
                                      @RequestParam("ob") int ob, @RequestParam("cb") int cb, @RequestParam("dim") String dim)
    {
        intable table= new intable();
        table.setItemName(name);
        table.setUnitMeasure(measure);
        table.setCost(cost);
        table.setOpenBalance(ob);
        table.setCurrBalance(cb);
        table.setDimension(dim);

        return inventoryService.entry(table);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public intable invetoryItemDelete(@RequestParam("name") String name)
    {
        return inventoryService.delete(name);
    }

    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public List<intable> display()
    {
        return inventoryService.display();
    }
}

