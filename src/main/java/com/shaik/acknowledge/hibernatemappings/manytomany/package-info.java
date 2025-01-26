package com.shaik.acknowledge.hibernatemappings.manytomany;

/**
 * @author shaik shafin
 * @since 26-01-2025 10:00 PM
 *
 * -------------------------------------------------------------------------------------
 *                                  HIBERNATE MAPPINGS
 * -------------------------------------------------------------------------------------
 *
 * MANY TO MANY : UNI DIRECTIONAL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Many to many means, one parent can have multiple children and one child can have multiple parents.
 * Here no entity depends on another entity.
 * In order to achieve many to many we have to create three table
 * 1. parent table
 * 2. child table
 * 3. junction table which maintains the relationship between parent and child table
 *
 * You have to define in @JOINTABLE annotation
 * name = give the third table name
 * joinColumns = give the first table column names
 * inverseJoinColumns = give the second table column names
 *
 *
 * MANY TO MANY : BI DIRECTIONAL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * In bi direction we have to set ManyToMany annotation with mappedBy
 *
 */