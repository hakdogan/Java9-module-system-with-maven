#!/usr/bin/env bash
export JDK_HOME='/Library/Java/JavaVirtualMachines/jdk-9.jdk/Contents/Home' #You must customize the path of JDK according to your own system.
$JDK_HOME/bin/java --module-path libs:database/libs -m info/com.kodcu.info.InfoUser