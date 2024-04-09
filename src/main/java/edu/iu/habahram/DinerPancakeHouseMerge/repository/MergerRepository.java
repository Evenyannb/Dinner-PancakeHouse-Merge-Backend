package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.CompositeIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MergerRepository {
    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Dinner"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Lunch"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    public List<MenuItemRecord> getAllVegetarianMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Dinner"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Lunch"));

        MenuItem[] menuItems = allMenus.getItems();

        List<MenuItemRecord> vegetarianRecords = Arrays.stream(menuItems)
                .filter(MenuItem::isVegetarian)
                .map(x -> new MenuItemRecord(x.getName(), x.getDescription(), x.isVegetarian(), x.getPrice()))
                .collect(Collectors.toList());

        return vegetarianRecords;
    }
    public List<MenuItemRecord> getAllLunchMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new CafeMenu("CAFE MENU", "Lunch"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> lunch = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return lunch;
    }
    public List<MenuItemRecord> getAllDinnerMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));

        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> dinner = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return dinner;
    }

    public List<MenuItemRecord> getAllBreakfastMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Dinner"));

        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> dinner = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return dinner;
    }

}
