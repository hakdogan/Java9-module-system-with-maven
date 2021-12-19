/*
 * Created by hakdogan on 24/08/2017
 */

module database {
    requires java.sql;
    requires user;
    requires h2;
    requires org.apache.logging.log4j;
    exports com.kodcu.db;
}
