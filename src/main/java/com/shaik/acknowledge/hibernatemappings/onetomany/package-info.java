package com.shaik.acknowledge.hibernatemappings.onetomany;

/**
 * @author shaik shafin
 * @since 24-01-2025 7:00 PM
 *
 * -------------------------------------------------------------------------------------
 *                                  HIBERNATE MAPPINGS
 * -------------------------------------------------------------------------------------
 *
 * ONE TO MANY : UNI DIRECTIONAL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * one to many means, one parent can have multiple children.
 * As in one to one, we can not store the fk relationship in parent table.
 * because one record in table have multiple fk in child table
 * so how we can achieve this by creating a new table which holds the pk of parent table and fk of child table
 * that is the default behavaior of JPA, but there is another way that storing the parent table pk in child table
 * so that we have to use the @JoinColumn annotation
 * @JoinColumn(name = "fk", referencedColumnName = "pk")
 * In name -> we have to use fk that need to join.
 * but in referencedColumnName -> we have to use pk in table format like hibernate formated pk like authorId, bookId (not author_id, book_id)
 *
 * In parent domain we have list of child entities then if you one entity in collection then in table the fk will be null
 * But if you don't want to set to null instead you want to delete then put orphanRemoval = true. by default it is false.
 *
 * ONE TO MANY : BI DIRECTIONAL
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * In bi direction we have to set @JoinColumn to that table which holds the foreign key
 * Other table we just have to set mappedBy = "variableName" in child table.
 * @JoinColumn(name = "fk", referencedColumnName = "pk"), give the name that you want to join.
 *
 * NOTE: referenceColumnName is optional by default JPA join with PK of table or domain, it will work even if you don't mention it.
 */