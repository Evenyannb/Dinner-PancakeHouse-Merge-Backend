package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItemRecord;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CompositeIterator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    MergerRepository mergerRepository;

    public MergerController(MergerRepository mergerRepository) {
        this.mergerRepository = mergerRepository;
    }

    @GetMapping
    public List<MenuItemRecord> get() {
            List<MenuItemRecord> items = mergerRepository.getTheMenuItems();
            return items;
    }

}