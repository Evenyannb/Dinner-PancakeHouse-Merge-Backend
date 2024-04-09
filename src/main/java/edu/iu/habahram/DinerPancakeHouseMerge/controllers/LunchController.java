package edu.iu.habahram.DinerPancakeHouseMerge.controllers;


import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lunch")
public class LunchController {

    MergerRepository mergerRepository;

    public LunchController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
        List<MenuItemRecord> items = mergerRepository.getAllLunchMenuItems();
        return items;
    }
}
