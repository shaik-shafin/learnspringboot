package com.shaik.acknowledge.jpa;

/**
 * @author shaik shafin
 * @since 21-01-2025 10:00 PM
 *
 * <p>Add jpa dependency in the pom and along with jpa, hibernate also get added</p>
 * <p>In order to process it we need mysql-connector-j also</p>
 * <p>On next step you need to give datasource either in application.properties or @configuration</p>
 * <p>Then create table in the database</p>
 * <p>Next you have to create associate domain for that</p>
 * <p>Then create the interface and extends the JpsRepository<T, ID></p>
 * <p>Then make use of the service layer</p>
 */