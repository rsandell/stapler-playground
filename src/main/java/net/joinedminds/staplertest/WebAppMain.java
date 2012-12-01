package net.joinedminds.staplertest;

import com.google.inject.Guice;
import com.google.inject.Injector;
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
        Injector injector = Guice.createInjector(new StaplerTestModule());
        Stapler.setRoot(event, injector.getInstance(Main.class));
    }

    public void contextDestroyed(ServletContextEvent event) {
    }
}
