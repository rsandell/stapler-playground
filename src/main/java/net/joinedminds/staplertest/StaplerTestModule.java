package net.joinedminds.staplertest;

import com.google.inject.AbstractModule;

/**
 * Created with IntelliJ IDEA.
 * User: bobby
 * Date: 2012-12-01
 * Time: 21:55
 * To change this template use File | Settings | File Templates.
 */
public class StaplerTestModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Main.class).toInstance(new Main());
    }
}
