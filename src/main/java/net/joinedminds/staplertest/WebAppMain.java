package net.joinedminds.staplertest;

import org.kohsuke.stapler.Stapler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-11-21
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public class WebAppMain implements ServletContextListener {
    public void contextInitialized(ServletContextEvent event) {
        // BookStore.theStore is the singleton instance of the application
        Stapler.setRoot(event, Main.getInstance());
    }

    public void contextDestroyed(ServletContextEvent event) {
    }
}
