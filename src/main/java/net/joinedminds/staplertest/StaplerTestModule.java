package net.joinedminds.staplertest;

import com.google.inject.AbstractModule;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;
import net.joinedminds.staplertest.db.OrientProvider;

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
        bind(String.class).annotatedWith(Names.named("DB_URL")).toInstance("local:databases/staplertest");
        bind(String.class).annotatedWith(Names.named("DB_USER")).toInstance("admin");
        bind(String.class).annotatedWith(Names.named("DB_PASSWD")).toInstance("admin");
        bind(OObjectDatabaseTx.class).toProvider(OrientProvider.class);
        bind(Main.class);
    }
}
