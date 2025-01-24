package com.shaik.acknowledge.L2cache;

/**
 * @author shaik shafin
 * @since 24-01-2025 7:00 PM
 *
 * <p>
 *    Add <groupId>javax.cache</groupId> dependency which provides the interface that
 *    is used for caching.
 * </p>
 * <p>
 *    Add <groupId>org.ehcache</groupId> dependency which is the provider
 *    (implementation of about javax.cache).
 * </p>
 * <p>
 *    Add <groupId>org.hibernate</groupId> dependency which acts a bridge between
 *    cache-api and ehcache.
 * </p>
 * <p>
 *    Hibernate specific caching logic comes with this. like we use annotation over
 *    entities @cache or cache concurrency strategy. so specific logic executed which
 *    helps us.
 * </p>
 * <p>
 *    you have to enable ehcache in the application.properties.
 *    By default second level cache is false, you have to set to true.
 * </p>
 * <p>
 *    Add ehcache.xml in the src/main/resources, which is a logical group of cached data.
 *    for each region (or say group),we can apply different caching strategy like
 *    <li>eviction policy</li>
 *    <li>TTL</li>
 *    <li>cache size</li>
 *    <li>cache concurrency strategy</li>
 * </p>
 * <p>On domain level add an annotation @Cache(usage = ?, region = ?)</p>
 * <p>
 *     1.READ_ONLY - good for static data, if you try to update throw exception.
 *     2.READ_WRITE - during read puts share lock, during update puts exclusive lock.
 *     3.NONSTRICT_READ_WRITE - good heavy data, no share lock and no exclusive lock,
 *                              just cache data will be invalidated, do not update will latest data in db.
 *     4.NONSTRICT_READ - acquire READ lock and also WRITE lock.
 * </p>
 */