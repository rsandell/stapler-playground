package net.joinedminds.staplertest.model;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-11-23
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
public class Item {

    public static int count = 1;

    private int id;
    private String name;

    public Item() {
        id = (count++);
        name = "Item " + id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
