# contas-jpa

* Wildfly 16
* MariaDB 10.1
* JDK 11
* Eclipse IDE 2019-06
* Ubuntu Server 18.04.2 LTS
* Ubuntu Desktop 19.04


Datasource and driver configuration on $WILDFLY_HOME/standalone/configuration/standalone.xml:

```
<datasources>
    <datasource jndi-name="java:jboss/datasources/financasDS" pool-name="financasDS" enabled="true" use-java-context="true">
        <connection-url>jdbc:mariadb://10.0.3.10:3306/financas?useSSL=false</connection-url>
        <driver>mariadb</driver>
        <security>
            <user-name>alura</user-name>
            <password>alura</password>
        </security>
        <pool>
            <min-pool-size>10</min-pool-size>
            <max-pool-size>20</max-pool-size>
            <prefill>true</prefill>
        </pool>
    </datasource>
    <drivers>
        <driver name="mariadb" module="org.mariadb">
            <driver-class>org.mariadb.jdbc.Driver</driver-class>
        </driver>
    </drivers>
</datasources>
```

$WILDFLY_HOME/modules/system/layers/base/org/mariadb/main/module.xml:


```
<module xmlns="urn:jboss:module:1.5" name="org.mariadb">
    <resources>
        <resource-root path="mariadb-java-client-2.4.2.jar" />
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
```