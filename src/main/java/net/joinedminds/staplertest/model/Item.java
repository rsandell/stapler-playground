package net.joinedminds.staplertest.model;

import net.joinedminds.staplertest.Functions;
import net.joinedminds.staplertest.Main;
import net.joinedminds.staplertest.NavItem;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.StaplerResponse;

import javax.persistence.Id;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-11-23
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
public class Item implements NavItem {

    @Id
    private String id;
    private String name;
    String description;

    public Item() {
    }

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getNavId() {
        return getId().substring(1);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void doEditSubmit(StaplerRequest request, StaplerResponse response) throws IOException {
        request.bindParameters(this);
        Main.getInstance().getDb().save(this);
        List<Functions.Breadcrumb> breadcrumbs = Functions.getBreadcrumbs();

        if (!breadcrumbs.isEmpty()) {
            response.sendRedirect2(breadcrumbs.get(breadcrumbs.size()-1).getUrl());
        } else {
            response.sendRedirect2("/");
        }
    }

    @Override
    public String getNavDisplay() {
        return name;
    }
}
