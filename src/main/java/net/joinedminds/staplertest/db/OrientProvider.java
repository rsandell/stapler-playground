package net.joinedminds.staplertest.db;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.orientechnologies.orient.object.db.OObjectDatabasePool;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

import java.io.File;

/**
 * @author sandell.robert@gmail.com
 */
@Singleton
public class OrientProvider implements Provider<OObjectDatabaseTx> {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPasswd;

    ThreadLocal<OObjectDatabaseTx> context = new ThreadLocal<OObjectDatabaseTx>() {
        @Override
        protected OObjectDatabaseTx initialValue() {
            // OPEN THE DATABASE
            OObjectDatabaseTx db = OObjectDatabasePool.global().acquire(dbUrl, dbUser, dbPasswd);
            // REGISTER THE CLASS ONLY ONCE AFTER THE DB IS OPEN/CREATED
            db.getEntityManager().registerEntityClasses("net.joinedminds.staplertest.model");
            return db;
        }

        @Override
        public void remove() {
            get().close();
        }
    };

    @Inject
    public OrientProvider(@Named("DB_URL") String dbUrl, @Named("DB_USER") String dbUser, @Named("DB_PASSWD") String dbPasswd) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPasswd = dbPasswd;
        setUpDbIfNeeded();
    }

    private void setUpDbIfNeeded() {
        if (dbUrl.startsWith("local:")) {
            System.out.println("Local db!");
            File file = new File(dbUrl.substring("local:".length()));
            if(!file.exists()) {
                System.out.println("Creating the database at " + file.getAbsolutePath());
                OObjectDatabaseTx db = new OObjectDatabaseTx(dbUrl).create();
                db.close();
            }
        }
    }

    @Override
    public OObjectDatabaseTx get() {
        return context.get();
    }
}
