package net.joinedminds.staplertest;

import net.joinedminds.staplertest.ui.menu.DropDown;
import org.apache.commons.jelly.JellyContext;
import org.kohsuke.stapler.Stapler;

import java.util.LinkedList;

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
        DEFAULT_ITEM_CONTEXT_MENU.getMenuItems().add(new DropDown.MenuItem("#", "icon-edit", Messages._menu_Edit()));
        DEFAULT_ITEM_CONTEXT_MENU.getMenuItems().add(new DropDown.MenuItem("#", "icon-remove-circle", Messages._menu_Remove()));
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

    public DropDown getDefaultItemContextMenu() {
        return DEFAULT_ITEM_CONTEXT_MENU;
    }
}
