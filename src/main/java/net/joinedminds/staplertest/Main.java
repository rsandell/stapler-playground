package net.joinedminds.staplertest;

import com.google.inject.Singleton;
import net.joinedminds.staplertest.model.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-11-21
 * Time: 22:51
 * To change this template use File | Settings | File Templates.
 */
@Singleton
public class Main implements NavItem {

    private List<Item> items;

    public Main() {
        items = new LinkedList<Item>();
        for (int i = 0; i < 300; i++) {
            items.add(new Item());
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItem(int id) {
        for(Item i : items) {
            if(i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    @Override
    public String getNavDisplay() {
        return "Home";
    }
}
