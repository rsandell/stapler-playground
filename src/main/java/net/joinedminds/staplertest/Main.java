package net.joinedminds.staplertest;

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
public class Main {
    private static Main instance;

    private List<Item> items;

    public Main() {
        items = new LinkedList<Item>();
        for (int i = 0; i < 30; i++) {
            items.add(new Item());
        }
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public List<Item> getItems() {
        return items;
    }
}
