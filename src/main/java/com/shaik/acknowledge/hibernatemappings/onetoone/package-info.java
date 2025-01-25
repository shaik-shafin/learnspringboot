package com.shaik.acknowledge.hibernatemappings.onetoone;

/**
 * @author shaik shafin
 * @since 25-01-2025 10:00 PM
 * -------------------------------------------------------------------------------------
 *                                  HIBERNATE MAPPINGS
 * -------------------------------------------------------------------------------------
 *
 * ONE TO ONE UNI DIRECTION
 * ------------------------
 * Create two table with the name of member_details and member_address
 * Create domains and service layer
 * Add foreign key relation between member_details and member_address
 * The column name will be address_id
 * If you don't want to use of the @JoinColumn then the column should be the same
 * as the variable name you give in the domain
 * Such as if you give var name as memberAddress then JPA will create and try to find the
 * column name as member_address_id in member_details
 * By default OneToOne is EAGER
 * Cascade type will set to ALL then all delete, save, update happens to parent will also reflects to child entities
 * Foreign key should be mandatory to make the hibernate relationship
 * In order to prevent jackson to throw exception when you set fetchType to LAZY
 * Add @JsonIgnore or better to use DTO.
 *
 *
 * ONE TO ONE BI DIRECTION
 * -----------------------
 * In case of bi direction second table in our case member_address won't hold the
 * foreign key of member_details
 *
 * So which who will hold the foreign key is called OWNER side in our case member_details
 * which who will not hold the foreign key is called INVERSE side in our case member_address
 *
 * There is no changes in the table structure which remains same as like in uni directional
 * In order to achieve the bi directional relationship you have set @OneToOne(mappedBy = "memberAddress")
 * in MemberAddress domain class, and the mappedBy name should be the same name as the variable name in MemberDetails
 *
 * In bi direction there is a chance that you will get infinite loop of child to parent and parent to child.
 * To avoid this we have to use @JsonBackReference in Inverse side domain class
 * If we use @JsonManagedReference then following case will happen,
 * When we fetch the memberDetails obj then child entity memberAddress will also be fetched and stored in the JSON
 * When we fetch the memberAddress obj then parent entity memberDetails will not be fetched and stored in the JSON
 *
 * Then how to achieve this like either it might be memberDetails or memberAddress the relation entity also be formatted to be JSON
 * In order to achieve that you have to use @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "{PK}")
 * Above the entity class
 *
 * NOTE: while defining the columns in the domain setters and getters important
 */