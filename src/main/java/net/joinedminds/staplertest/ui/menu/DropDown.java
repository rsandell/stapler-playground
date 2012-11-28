package net.joinedminds.staplertest.ui.menu;

import org.jvnet.localizer.Localizable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-11-28
 * Time: 23:32
 * To change this template use File | Settings | File Templates.
 */
public class DropDown {
    private String id;
    private Localizable displayName;
    private List<MenuItem> menuItems;

    public DropDown(String id, Localizable displayName, List<MenuItem> menuItems) {
        this.id = id;
        this.displayName = displayName;
        this.menuItems = menuItems;
    }

    public String getId() {
        return id;
    }

    public Localizable getDisplayName() {
        return displayName;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public static class MenuItem {
        public static final MenuItem DIVIDER = new MenuItem(){
            public boolean isDivider() {
                return true;
            }
        };

        private int tabIndex;
        private String href;
        private String icon;
        private Localizable displayName;

        public MenuItem(String href, String icon, Localizable displayName) {
            this(-1, href, icon, displayName);
        }

        public MenuItem(int tabIndex, String href, String icon, Localizable displayName) {
            this.tabIndex = tabIndex;
            this.href = href;
            this.icon = icon;
            this.displayName = displayName;
        }

        private MenuItem() {

        }

        public int getTabIndex() {
            return tabIndex;
        }

        public String getHref() {
            return href;
        }

        public String getIcon() {
            return icon;
        }

        public Localizable getDisplayName() {
            return displayName;
        }
    }
}
