/*
 * Created by hakdogan on 24/08/2017
 */

module database {
    requires log4j.core;
    requires log4j.api;
    requires java.sql;
    requires user;
    requires h2;
    exports com.kodcu.db;
}