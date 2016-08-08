package com.example.Item_List;

import com.example.Production_Details.productionItemTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by sumi on 5/8/16.
 */
@RestController
public class ItemTableController {

    @Autowired
    ItemTableService itemTableService;

    @RequestMapping(value = "/itemTableEntry" , method = RequestMethod.POST)
    public ItemTable itemTableEntry(@RequestBody ITable iTable)
    {
        return itemTableService.entry(iTable);
    }

    @RequestMapping(value = "/getContent", method = RequestMethod.POST)
    public List<ItemTable> getContent ()
    {
        return itemTableService.display();
    }
}
