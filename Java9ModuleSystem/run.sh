#!/usr/bin/env bash
export JDK_HOME='/Library/Java/JavaVirtualMachines/jdk-9.jdk/Contents/Home' #You must customize the path of JDK according to your own system.
export MVN_REPOSITORY='/Users/hakdogan/.m2/repository' #You must customize the path of local maven repository according to your own system.
$JDK_HOME/bin/java --module-path database/target/database-1.0-SNAPSHOT.jar:info/target/info-1.0-SNAPSHOT.jar:user/target/user-1.0-SNAPSHOT.jar
:$MVN_REPOSITORY/org/apache/logging/log4j/log4j-core/2.8.2/log4j-core-2.8.2.jar:$MVN_REPOSITORY/org/apache/logging/log4j/log4j-api/2.8.2/log4j-api-2.8.2.jar:$MVN_REPOSITORY/com/h2database/h2/1.4.196/h2-1.4.196.jar -m info/com.kodcu.info.InfoUser