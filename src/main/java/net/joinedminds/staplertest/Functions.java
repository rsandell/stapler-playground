package net.joinedminds.staplertest;

import net.joinedminds.staplertest.ui.menu.DropDown;
import org.apache.commons.jelly.JellyContext;
import org.kohsuke.stapler.Ancestor;
import org.kohsuke.stapler.Stapler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-11-22
 * Time: 22:41
 * To change this template use File | Settings | File Templates.
 */
public class Functions {

    public static final String RESOURCE_PATH = "/resources";
    public static final String IMAGES_PATH = RESOURCE_PATH + "/images";

    public static final DropDown DEFAULT_ITEM_CONTEXT_MENU = new DropDown("pageContextMenu", Messages._menu_Edit(), new LinkedList<DropDown.MenuItem>());

    static {
        DEFAULT_ITEM_CONTEXT_MENU.getMenuItems().add(new DropDown.MenuItem("edit", "icon-edit", Messages._menu_Edit()));
        DEFAULT_ITEM_CONTEXT_MENU.getMenuItems().add(new DropDown.MenuItem("delete", "icon-remove-circle", Messages._menu_Remove()));
    }

    public static void initPageVariables(JellyContext context) {
        String rootURL = Stapler.getCurrentRequest().getContextPath();

        Functions h = new Functions();
        context.setVariable("h", h);

        // The path starts with a "/" character but does not end with a "/" character.
        context.setVariable("rootURL", rootURL);

        context.setVariable("resURL", rootURL + RESOURCE_PATH);
        context.setVariable("imagesURL", rootURL + IMAGES_PATH);
    }

    public static String appendIfNotNull(String text, String suffix, String nullText) {
        return text == null ? nullText : text + suffix;
    }

    public static Object ifNull(Object obj, Object thenVal) {
        return obj == null ? thenVal : obj;
    }

    public static List<Breadcrumb> getBreadcrumbs() {
        List<Ancestor> ancestors = Stapler.getCurrentRequest().getAncestors();
        List<Breadcrumb> list = new LinkedList<Breadcrumb>();
        for(Ancestor ancestor : ancestors) {
            if (ancestor.getObject() instanceof NavItem) {
                NavItem item = (NavItem) ancestor.getObject();
                list.add(new Breadcrumb(ancestor.getUrl(), item.getNavDisplay()));
            }
        }
        return list;
    }

    public DropDown getDefaultItemContextMenu() {
        return DEFAULT_ITEM_CONTEXT_MENU;
    }

    public static class Breadcrumb {
        private String url;
        private String display;

        public Breadcrumb(String url, String display) {
            this.url = url;
            if (this.url == null || this.url.isEmpty()) {
                this.url = "/";
            }
            this.display = display;
        }

        public String getUrl() {
            return url;
        }

        public String getDisplay() {
            return display;
        }
    }
}
