package net.joinedminds.staplertest.db;

import com.google.inject.*;
import com.orientechnologies.orient.core.id.ORID;
import com.orientechnologies.orient.core.id.ORecordId;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import com.orientechnologies.orient.object.iterator.OObjectIteratorClass;
import net.joinedminds.staplertest.model.Item;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sandell.robert@gmail.com
 */
@Singleton
public class DB {
    private Provider<OObjectDatabaseTx> db;

    @Inject
    public DB(Provider<OObjectDatabaseTx> db) {
        this.db = db;
    }

    public List<Item> getItems() {
        OObjectIteratorClass<Item> items = db.get().browseClass(Item.class);
        List<Item> list = new LinkedList<Item>();
        for(Item i: items) {
            list.add(i);
        }
        return list;
    }

    public Item getItem(String id) {
        if(!id.startsWith("#")) {
            id = "#" + id;
        }
        return db.get().load(new ORecordId(id));
    }

    public Item createItem() {
        return db.get().newInstance(Item.class);
    }

    public Item save(Item item) {
        return db.get().save(item);
    }
}
