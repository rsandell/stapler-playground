package net.joinedminds.staplertest;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.joinedminds.staplertest.db.DB;
import net.joinedminds.staplertest.model.Item;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import java.io.IOException;
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

    private DB db;
    private static Main instance;

    @Inject
    public Main(DB db) {
        instance = this;
        this.db = db;
    }

    public List<Item> getItems() {
        return db.getItems();
    }

    public Item getItem(String id) {
        return db.getItem(id);
    }

    @Override
    public String getNavDisplay() {
        return "Home";
    }

    public void doNewSubmit(StaplerRequest request, StaplerResponse response) throws IOException {
        String name = request.getParameter("name");
        Item item = db.createItem();
        item.setName(name);
        item = db.save(item);
        response.sendRedirect2("/item/" + item.getNavId());
    }

    public static Main getInstance() {
        return instance;
    }

    public DB getDb() {
        return db;
    }
}
